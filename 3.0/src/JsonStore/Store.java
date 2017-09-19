package JsonStore;

import LinkedList.CircularList.CircularList;

public class Store {

    private String storeName;
    private CircularList docs;

    public Store(String storeName, CircularList docs){
        this.storeName=storeName;
        this.docs= docs;
    }

    public void setDocs(CircularList docs) {
        this.docs = docs;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public CircularList getDocs() {
        return this.docs;
    }

    public String getStoreName() {
        return this.storeName;
    }


}
