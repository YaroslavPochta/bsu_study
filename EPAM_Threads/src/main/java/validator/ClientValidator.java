package validator;

import model.Auction;
import model.ClientData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientValidator {
    private static final Logger LOGGER = LogManager.getLogger(ClientValidator.class);

    public boolean isEnoughMoney( Auction auction, ClientData client ) {
        String message;
        if (client.getCountOfMoney() < auction.getCurrentPriceOfLot()) {
            message = client.getId() + " does't have enough money for continuation this bidding";
            LOGGER.info(message);
            return false;
        }
        return true;
    }

    public boolean isEnoughMoney( int increasingPrice, Auction auction, ClientData client ) {
        String message;
        if (auction.getCurrentPriceOfLot() + increasingPrice > client.getCountOfMoney()) {
            message = client.getId() + " does't have enough money for continuation this bidding";
            LOGGER.info(message);
            return false;
        }
        return true;
    }
}