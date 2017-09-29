package Background.JsonObject;

import Background.Documents.Attribute;
import Background.LinkedList.SimpleList.SimpleList;

public class ObjectJ {
    private SimpleList<Attribute> attributeList;
    private SimpleList<Objeto> row;

    public ObjectJ(SimpleList<Attribute> attributeList, SimpleList<Objeto> row){
        this.attributeList=attributeList;
        this.row=row;

    }
    public ObjectJ(SimpleList<Attribute> attributeList){
        this.attributeList=attributeList;
        this.row=new SimpleList<>();
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


    public void showRowValue(){
        if (!this.row.isEmpty()) {
            for (int i = 0; i < this.row.length(); ++i) {
                System.out.println(this.row.find(i).getItem().getValue());
            }
        }else {
            System.out.println("EMPTY");
        }
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
            else {
                Objeto x = new Objeto(this.attributeList.find(i).getItem().getName(),
                        this.attributeList.find(i).getItem().getType(),
                        this.attributeList.find(i).getItem().isPrimary(),
                        this.attributeList.find(i).getItem().getValue());
                this.row.addLast(x);
            }
        }
    }
    public void createRow (String attribute,Object value){

        for (int i=0;i<this.attributeList.length();++i){
            if (this.attributeList.find(i).getItem().getName()==attribute){
                Attribute n = this.attributeList.findItem(i);
                if(isSameType(n,value)){
                    Objeto x = new Objeto(attribute,n.getType(), n.isPrimary(),value);
                    this.row.addLast(x);
                }
                else{
                    Objeto x = new Objeto(attribute,n.getType(), n.isPrimary(),n.getValue());
                    this.row.addLast(x);
                }
            }

        }
    }
    public void createRowFromJson (String attribute,Object value){

        for (int i=0;i<this.attributeList.length();++i){
            if (this.attributeList.findItem(i).getName().equals(attribute)){
                Attribute n = this.attributeList.find(i).getItem();
                Objeto x = new Objeto(attribute,n.getType(), n.isPrimary(),value);
                this.row.addLast(x);
            }
        }
    }

    public SimpleList<Objeto> getRow() {
        return this.row;
    }
}
