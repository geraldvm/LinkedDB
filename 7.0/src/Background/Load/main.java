/*package Load;

import Documents.JsonDoc;
import JsonStore.Store;
import LinkedList.CircularList.CircularList;
import LinkedList.DoubleList.DoubleList;

import java.time.LocalDate;

public class main {

    public static void main(String[] args) {
        Load z = new Load();
        z.loadFiles();
        DoubleList a = z.getStoreList();
        //System.out.println(a.find(1).getItem().getClass().getName());
        Store l = a.find(0).getItem();
        System.out.println(l.getStoreName());
        CircularList x = l.getDocs();
        JsonDoc h = x.find(1).getItem();
        System.out.println(h.getName());
        LocalDate fecha= LocalDate.of(2016,6,5);
        //fecha.format("dd/mm/yy");
        System.out.println(fecha);

    }
}*/
