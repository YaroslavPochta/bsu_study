import java.util.Date;

public class Message {
    private Date date;
    private int idFrom;
    private int idTo;

    public Message(String[] strings) {
        this.date = parseDate(strings[0]);
        this.idFrom = Integer.parseInt(strings[1]);
        this.idTo = Integer.parseInt(strings[2]);
    }

    public Date parseDate(String date){
        String[] strings = date.split("-");
        return new Date(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
    }

    public Date getDate() {
        return date;
    }

    public int getIdFrom() {
        return idFrom;
    }

    public int getIdTo() {
        return idTo;
    }
}
