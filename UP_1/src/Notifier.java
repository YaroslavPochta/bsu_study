import java.util.HashSet;
import java.util.Set;

public class Notifier {
    private Set<Notifiable> notifiables;

    Notifier(Set<Postgraduate> set){
        notifiables = new HashSet<>();

        for(var i:set){
            notifiables.add(i);
        }
    }

    public void doNotifyAll(String message){
        for(var i: notifiables){
            i.notify(message);
        }
    }
}
