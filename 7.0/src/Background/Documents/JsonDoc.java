package Background.Documents;

import Background.JsonObject.ObjectJSON;
import Background.LinkedList.SimpleList.SimpleList;
import Background.Documents.Attribute;

public class JsonDoc {
    private String name;
    private SimpleList<Attribute> attributeList;
    private SimpleList<ObjectJSON> objectList;

    public JsonDoc(String name){
        this.name=name;
        this.attributeList=new SimpleList<>();
        this.objectList=new SimpleList<>();
    }

    public JsonDoc (String name, SimpleList<Attribute> attributeList, SimpleList<ObjectJSON> objectList){
        this.name=name;
        this.attributeList=attributeList;
        this.objectList=objectList;

    }

    public String getName() {
        return this.name;
    }

    public SimpleList<Attribute> getAttributeList() {
        return this.attributeList;
    }

    public void addAttribute(String name, int type, boolean key, boolean required){
        Attribute x = new Attribute(name,type, key, required);
        this.attributeList.addLast(x);
    }
    public void addAttribute(String name,int type, boolean key,boolean required,Object value){
        Attribute x = new Attribute(name,type, key, required, value);
        this.attributeList.addLast(x);
    }
    /*public void addAttribute(String name,int type, boolean key,boolean required,int year, int month, int day, int hour, int min){
        Attribute x = new Attribute(name,type, key, required, year, month, day, hour, min);
        attributeList.addLast(x);
    }*/

    public void addObject(String attribute,Object PK, Object value){
        for (int i=0;i<this.attributeList.length();++i){
            ObjectJSON x = new ObjectJSON(this.getAttributte(i), PK,value);
            this.objectList.addLast(x);
        }

    }

    public Attribute getAttributte(int x){
        Attribute z = this.attributeList.find(x).getItem();
        return z;
    }

    public SimpleList<ObjectJSON> getObjectList() {
        return this.objectList;
    }

    public void setAttributeList(SimpleList<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public void setObjectList(SimpleList<ObjectJSON> objectList) {
        this.objectList = objectList;
    }
}
