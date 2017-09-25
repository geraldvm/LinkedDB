package Background.JsonObject;

import Background.Documents.Attribute;
import Background.LinkedList.SimpleList.SimpleList;

public class ObjectJ {
    private SimpleList<Attribute> attributeList;
    private Object value;
    private SimpleList<Objeto> row;
    private boolean primaryKey;
    private Attribute attribute;

    public ObjectJ(SimpleList<Attribute> attributeList, SimpleList<Objeto> row){
        this.attributeList=attributeList;
        this.row=row;

    }
    public ObjectJ(SimpleList<Attribute> attributeList){
        this.attributeList=attributeList;
        this.row=new SimpleList<>();
    }


    public void setObject(Attribute attribute, Object value){
        if(isSameType(attribute,value)){
            this.value=value;
        }
    }

    public Object getValue() {
        return this.value;
    }



    private boolean isSameType(Attribute attribute,Object value){
        String x = value.getClass().getSimpleName();
        switch (x){
            case "Integer":
                return attribute.getType()=="int";
            case "Double":
                return attribute.getType()=="float";
            case "String":
                return attribute.getType()=="String";
            case "LocalDateTime":
                return attribute.getType()=="date";
        }return false;
    }


    public void show(){
        System.out.println(this.value);
    }


    public void createRow (Object...value){

        for (int i=0;i<this.attributeList.length();++i){
            if(isSameType(this.attributeList.find(i).getItem(),value[i])){
                Objeto x = new Objeto(this.attributeList.find(i).getItem().getName(),
                        this.attributeList.find(i).getItem().getType(),
                        this.attributeList.find(i).getItem().isPrimary(),
                        value[i]);
                this.row.addLast(x);
            }
        }
    }

    public SimpleList<Objeto> getRow() {
        return this.row;
    }
}
