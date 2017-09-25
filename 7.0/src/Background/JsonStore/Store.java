package Background.JsonStore;

import Background.Documents.JsonDoc;
import Background.LinkedList.CircularList.CircularList;

public class Store {

    private String storeName;
    private CircularList<JsonDoc> docs;

    public Store (String storeName){
        this.storeName=storeName;
        this.docs=new CircularList<>();
    }
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

    public CircularList<JsonDoc> getDocs() {
        return this.docs;
    }

    public String getStoreName() {
        return this.storeName;
    }




    public void newDoc(String name){
        JsonDoc a = new JsonDoc(name);
        this.docs.addLast(a);
    }
    public void addAtrribute(JsonDoc a,String name,int type, boolean key, boolean required, Object value){
        a.addAttribute(name,type,key,required,value);
    }
    public void addAtrribute(JsonDoc a,String name,int type, boolean key, boolean required){
        a.addAttribute(name,type,key,required);
    }



}
