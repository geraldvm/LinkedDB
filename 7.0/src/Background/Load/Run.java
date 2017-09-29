package Background.Load;

import Background.Documents.Attribute;
import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;
import Background.LinkedList.SimpleList.SimpleList;
import org.json.simple.JSONObject;

public class Run {
    public static void main(String[] args) {
       LoadFile z = new LoadFile();
        z.loadStores();
        DoubleList<Store> x= z.getStoreList();

    }



}
