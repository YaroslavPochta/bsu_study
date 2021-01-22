package model;

import java.util.Objects;

public class ClientData {
    private final String id;
    private int countOfMoney;

    public ClientData( String clientId, int clientCountOfMoney ) {
        this.id = clientId;
        this.countOfMoney = clientCountOfMoney;
    }

    public String getId() {
        return id;
    }

    public int getCountOfMoney() {
        return countOfMoney;
    }

    public void setCountOfMoney( int clientCountOfMoney ) {
        this.countOfMoney = clientCountOfMoney;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) {
            return true;
        }
        if (!( o instanceof ClientData )) {
            return false;
        }
        ClientData that = (ClientData) o;
        return getCountOfMoney() == that.getCountOfMoney()
                && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountOfMoney());
    }

    @Override
    public String toString() {
        return "ClientData{" + "id='" + id + '\''
                + ", countOfMoney=" + countOfMoney + '}';
    }
}