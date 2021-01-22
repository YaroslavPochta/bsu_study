import model.Auction;
import model.ClientData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.ClientValidator;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class ClientAction implements Callable<Boolean> {
    private ClientData client;
    private int price;
    private final Auction auction;
    private final Phaser phaser;
    private boolean random = new Random().nextBoolean();
    private static final Logger LOGGER = LogManager.getLogger(ClientAction.class);
    private boolean firstBid = true;
    private static final int FIRST_INCREASING = 20;
    private static final int NEXT_INCREASING = 5;
    private static final ClientValidator VALIDATOR = new ClientValidator();

    public ClientAction( ClientData clientData, Phaser personPhaser, Auction personAuction, int bidPrice ) {
        this.client = clientData;
        this.price = bidPrice;
        this.auction = personAuction;
        this.phaser = personPhaser;
    }

    public Boolean call() {
        try {
            String message;
            int increasingPrice;
            for (int i = 0; i < auction.getLotsNumber(); i++) {
                long startMilli = System.currentTimeMillis();
                while (random) {
                    if (( System.currentTimeMillis() - startMilli ) >= auction.getMaxTimeOfBiddingInMilliseconds()) {
                        message = this.client.getId() + " wanted to increase price, but his time were passed.";
                        LOGGER.info(message);
                        break;
                    }
                    TimeUnit.MILLISECONDS.sleep(auction.getTimeOfSleepingInMilliseconds());
                    if (phaser.getArrivedParties() == auction.getNumberOfClients() && this.auction.getCurrentPriceOfLot() == price) {
                        break;
                    }
                    message = this.client.getId() + " began to think about price...";
                    LOGGER.info(message);
                    TimeUnit.SECONDS.sleep(1);
                    if (phaser.getArrivedParties() != auction.getNumberOfClients()) {
                        if (VALIDATOR.isEnoughMoney(auction, client)) {
                            if (firstBid) {
                                price = auction.getCurrentPriceOfLot();
                                increasingPrice = new Random().nextInt(FIRST_INCREASING);
                                if (VALIDATOR.isEnoughMoney(increasingPrice, auction, client)) {
                                    price += increasingPrice;
                                    firstBid = false;
                                } else {
                                    break;
                                }
                            } else {
                                increasingPrice = new Random().nextInt(NEXT_INCREASING);
                                if (VALIDATOR.isEnoughMoney(increasingPrice, auction, client)) {
                                    price = auction.getCurrentPriceOfLot() + increasingPrice;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        message = client.getId() + " ready to give " + price;
                        LOGGER.info(message);
                    } else {
                        if (phaser.getArrivedParties() == auction.getNumberOfClients() && this.auction.getCurrentPriceOfLot() >= price) {
                            increasingPrice =
                                    new Random().nextInt(NEXT_INCREASING);
                            if (VALIDATOR.isEnoughMoney(increasingPrice, auction, client)) {
                                price = auction.getCurrentPriceOfLot() + increasingPrice;
                            } else {
                                break;
                            }
                            message = client.getId() + " ready to give " + price;
                            LOGGER.info(message);
                        } else {
                            random = false;
                        }
                    }
                    if (this.price > this.auction.getCurrentPriceOfLot()) {
                        auction.setCurrentPriceOfLot(this.price);
                        auction.setWinner(this.client);
                    }
                    if (random) {
                        random = new Random().nextBoolean();
                    }
                    TimeUnit.MILLISECONDS.sleep(auction.getTimeOfSleepingInMilliseconds());
                }
                this.phaser.arriveAndAwaitAdvance();
                random = new Random().nextBoolean();
                firstBid = true;
                TimeUnit.MILLISECONDS.sleep(auction.getTimeOfSleepingInMilliseconds());
            }
        } catch (InterruptedException e) {
            LOGGER.error("Bidding were interrupted unexpectedly!");
            Thread.currentThread().interrupt();
        }
        return true;
    }
}