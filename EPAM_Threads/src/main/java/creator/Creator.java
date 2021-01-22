package creator;

import model.ClientData;
import model.Lot;
import validator.CreatorValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Creator {
    private CreatorValidator creatorValidator = new CreatorValidator();

    public List<ClientData> createListOfClients( Map.Entry<List<Map.Entry<String, Integer>>, List<Map.Entry<String, Integer>>> list ) {
        List<ClientData> lots = new ArrayList<>();
        for (int i = 0; i < list.getKey().size(); i++) {
            if (creatorValidator.isRightParameters(list.getKey().get(i))) {
                lots.add(new ClientData(list.getKey().get(i).getKey(), list.getKey().get(i).getValue()));
            }
        }
        return lots;
    }

    public List<Lot> createListOfLots( Map.Entry<List<Map.Entry<String, Integer>>, List<Map.Entry<String, Integer>>> list ) {
        List<Lot> clients = new ArrayList<>();
        for (int i = 0; i < list.getValue().size(); i++) {
            if (creatorValidator.isRightParameters(list.getKey().get(i))) {
                clients.add(new Lot(list.getValue().get(i).getKey(), list.getValue().get(i).getValue()));
            }
        }
        return clients;
    }
}

