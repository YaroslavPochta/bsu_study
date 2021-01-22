import creator.Creator;
import model.Auction;
import model.ClientData;
import model.Lot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.Parser;
import reader.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Phaser;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final int MAX_TIME_OF_SLEEPING = 200;
    private static final int MAX_TIME_OF_BIDDING_FOR_EVERY_LOT = 2_400;
    private static Reader reader = new Reader();
    private static Parser parser = new Parser();
    private static Creator creator = new Creator();
    private static List<Future<Boolean>> clientActions = new ArrayList<>();
    private static final String FILENAME = "src\\main\\resources\\input\\data";

    //TODO: JSON for input

    public static void main( String[] args ) {
        List<String> list = reader.readFromFile(FILENAME);
        Map.Entry<List<Map.Entry<String, Integer>>, List<Map.Entry<String, Integer>>> pair = parser.parse(list);
        List<Lot> lots = creator.createListOfLots(pair);
        List<ClientData> clients = creator.createListOfClients(pair);
        Phaser phaser = new Phaser(clients.size() + 1);
        ExecutorService executor = Executors.newFixedThreadPool(clients.size());
        Auction auction = Auction.getInstance(clients.size(), MAX_TIME_OF_BIDDING_FOR_EVERY_LOT,
                MAX_TIME_OF_SLEEPING, lots.size(), lots.get(0).getStartPrice());

        LOGGER.info("So, first Lot is \"" + lots.get(0).getName() + "\". Start price is : " + lots.get(0).getStartPrice());
        for (int i = 0; i < clients.size(); i++) {
            ClientAction clientAction = new ClientAction(clients.get(i), phaser, auction, lots.get(0).getStartPrice());
            clientActions.add(executor.submit(clientAction));
        }
        startBidding(lots, phaser, auction);
        executor.shutdown();
    }

    private static void startBidding( List<Lot> lots, Phaser phaser, Auction auction ) {
        String message;
        for (int i = 0; i < lots.size(); i++) {
            phaser.arriveAndAwaitAdvance();
            if (lots.get(i).getStartPrice() == auction.getCurrentPriceOfLot()) {
                message = "Loot number " + i + " with " + lots.get(i).getName() + " wasn't sold. Nobody wanted to buy it.\n";
            } else {
                message = "Loot number " + ( i + 1 ) + " with " + lots.get(i).getName() + " was sold! It was sold for the "
                        + auction.getCurrentPriceOfLot() + "$ to " + auction.getWinner().getId() + ".\n";
                auction.getWinner().setCountOfMoney(auction.getWinner().
                        getCountOfMoney() - auction.getCurrentPriceOfLot());
            }
            LOGGER.info(message);
            if (lots.size() != i + 1) {
                auction.setCurrentPriceOfLot(lots.get(i + 1).getStartPrice());
                message = "So, next Lot is \"" + lots.get(i + 1).getName() + "\". Start price is : " + lots.get(i + 1).getStartPrice();
                LOGGER.info(message);
            }
        }
    }
}