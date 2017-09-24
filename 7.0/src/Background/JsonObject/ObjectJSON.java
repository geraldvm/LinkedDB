package Background.JsonObject;

import Background.Documents.Attribute;
import Background.LinkedList.SimpleList.SimpleList;

public class ObjectJSON {
    private SimpleList<Attribute> attributeList;
    private Object value;
    private String nameAttribute;
    private Object primaryKey;
    private Attribute attribute;

    public ObjectJSON(SimpleList<Attribute> attributeList, Object primaryKey, Object value){
        this.attributeList=attributeList;
        this.nameAttribute=nameAttribute;
        this.primaryKey=primaryKey;
        setObject(value);
    }
    public ObjectJSON(Attribute attribute, Object value, Object primaryKey){
        this.attribute=attribute;
        this.nameAttribute=this.attribute.getName();
        this.primaryKey=primaryKey;
        setObject(value);
    }
    public ObjectJSON(String nameAttribute, Object value,Object primaryKey){
        //This ONLY FOR LOAD
        this.nameAttribute=nameAttribute;
        this.value=value;
        this.primaryKey=primaryKey;
    }

    public void setObject(Object value){
        if(isSameType(value)){
            this.value=value;
        }
    }

    public Object getValue() {
        return this.value;
    }

    public String getNameAttribute() {
        return this.nameAttribute;
    }

    private boolean isSameType(Object value){
        String x = value.getClass().getSimpleName();
        for(int i=0;i<this.attributeList.length();++i){
            if(attributeList.find(i).getItem().getName()==this.nameAttribute){
                switch (x){
                    case "Integer":
                        return this.attributeList.find(i).getItem().getType()=="int";
                    case "Double":
                        return this.attributeList.find(i).getItem().getType()=="float";
                    case "String":
                        return this.attributeList.find(i).getItem().getType()=="String";
                    case "LocalDateTime":
                        return this.attributeList.find(i).getItem().getType()=="date";
                    default:
                        System.out.println("DEFAULT");
                        return false;
                }
            }
        }return false;
    }

    public void show(){
        System.out.println(this.value);
    }




}
