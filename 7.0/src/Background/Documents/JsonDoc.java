package Background.Documents;

import Background.JsonObject.ObjectJ;
import Background.JsonObject.ObjectJSON;
import Background.LinkedList.SimpleList.SimpleList;
import Background.Documents.Attribute;

public class JsonDoc {
    private String name;
    private SimpleList<Attribute> attributeList;
    private SimpleList<ObjectJ> objectList;

    public JsonDoc(String name){
        this.name=name;
        this.attributeList=new SimpleList<>();
        this.objectList=new SimpleList<>();
    }

    public JsonDoc (String name, SimpleList<Attribute> attributeList, SimpleList<ObjectJ> objectList){
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

    public void addObject(Object...value){
        ObjectJ x = new ObjectJ(this.attributeList);
        for(int i=0;i<value.length;++i){
            x.createRow(this.attributeList.find(i).getItem().getName(),value[i]);
        }
        this.objectList.addLast(x);

    }

    public Attribute getAttributte(int x){
        Attribute z = this.attributeList.find(x).getItem();
        return z;
    }

    public SimpleList<ObjectJ> getObjectList() {
        return this.objectList;
    }

    public void setAttributeList(SimpleList<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public void setObjectList(SimpleList<ObjectJ> objectList) {
        this.objectList = objectList;
    }

}
