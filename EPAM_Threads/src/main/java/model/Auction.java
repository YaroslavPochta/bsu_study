package model;

public final class Auction {
    private int currentPriceOfLot;
    private ClientData winner;
    private final int numberOfClients;
    private final int maxTimeOfBiddingInMilliseconds;
    private final int timeOfSleepingInMilliseconds;
    private int lotsNumber;
    private static Auction instance;

    private Auction( int number, int maxTimeOfBidding, int timeOfSleeping, int lotsNumb, int currentPrice ) {
        this.numberOfClients = number;
        this.maxTimeOfBiddingInMilliseconds = maxTimeOfBidding;
        this.timeOfSleepingInMilliseconds = timeOfSleeping;
        this.lotsNumber = lotsNumb;
        this.currentPriceOfLot = currentPrice;
    }

    public static synchronized Auction getInstance( int number, int maxTimeOfBidding, int timeOfSleeping, int lotsNumb, int currentPrice ) {
        if (instance == null) {
            instance = new Auction(number, maxTimeOfBidding, timeOfSleeping, lotsNumb, currentPrice);
        }
        return instance;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public ClientData getWinner() {
        return this.winner;
    }

    public void setWinner( ClientData auctionWinner ) {
        this.winner = auctionWinner;
    }

    public int getCurrentPriceOfLot() {
        return currentPriceOfLot;
    }

    public void setCurrentPriceOfLot( int currentPrice ) {
        this.currentPriceOfLot = currentPrice;
    }

    public int getMaxTimeOfBiddingInMilliseconds() {
        return maxTimeOfBiddingInMilliseconds;
    }

    public int getTimeOfSleepingInMilliseconds() {
        return timeOfSleepingInMilliseconds;
    }

    public int getLotsNumber() {
        return lotsNumber;
    }
}