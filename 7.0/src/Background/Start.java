package Background;

import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;

public class Start {

    private DoubleList<Store> storeList;

    public Start(){
        this.storeList = new DoubleList<>();
    }

    public DoubleList<Store> getStoreList() {
        return this.storeList;
    }

    public void setStoreList(DoubleList<Store> storeList) {
        this.storeList = storeList;
    }

    public void newStore(String name){
        Store a = new Store(name);
        this.storeList.addLast(a);
    }

    public Store getStore(int i){
        return this.storeList.find(i).getItem();
    }
    public int getAmountStore(){
        return this.storeList.length();
    }
}
