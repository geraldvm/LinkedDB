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
    public Store getStore(String name){
        for (int i=0;i<this.storeList.length();i++){
            if (this.storeList.find(i).getItem().getStoreName()==name){
                return this.storeList.find(i).getItem();
            }
        }
        return null;
    }
    public int getAmountStore(){
        return this.storeList.length();
    }

    public void deleteStore(String name){
        for (int i=0;i<this.storeList.length();++i){
            if (this.storeList.find(i).getItem().getStoreName()==name){
                this.storeList.deletePos(i);
            }
        }
        //this.storeList.deletePos(pos);
    }
    public void showStore(){
        if (!this.storeList.isEmpty()) {
            for (int i = 0; i < this.storeList.length(); ++i) {
                System.out.println(this.storeList.find(i).getItem().getStoreName());
            }
        }
    }
}
