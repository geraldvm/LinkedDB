package Load;

import JsonStore.Store;
import LinkedList.CircularList.CircularList;
import LinkedList.DoubleList.DoubleList;

public class main {

    public static void main(String[] args) {
        Load z = new Load();
        z.loadFiles();
        DoubleList a = z.getStoreList();
        //System.out.println(a.find(1).getItem().getClass().getName());
        Store l = a.find(0).getItem();
        System.out.println(l.getStoreName());
        CircularList x = l.getDocs();
        x.show();
        System.out.println(x.find(0));

    }
}
