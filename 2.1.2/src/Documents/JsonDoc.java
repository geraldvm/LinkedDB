package Documents;
import org.json.simple.JSONObject;
import LinkedList.SimpleList.SimpleList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class JsonDoc {
    private String name;
    private SimpleList attributeList;

    public JsonDoc(String name){
        this.name=name;
        this.attributeList=new SimpleList();
    }

    public JsonDoc (String name, SimpleList attributeList){
        this.name=name;
        this.attributeList=attributeList;
    }

    public String getName() {
        return this.name;
    }

    public SimpleList getAttributeList() {
        return this.attributeList;
    }

    public void addAtribute(String name,boolean key,boolean required,int type, Object value){
        addAttribute_aux(name,key,required,type,value);
    }
    private void addAttribute_aux(String name,boolean key,boolean required,int type, Object value){
        //Tipo del atributo: entero, flotante, cadena, fecha-hora
        Object x[]=new Object[2];
        if(type==1) {
            Attribute<Integer> newAt = new Attribute<>();
            newAt.setAttribute(name,"int",key,required);
            newAt.setValue((Integer)value);
            x[0]=type;
            x[1]=newAt;
            this.attributeList.addLast(x);
            newAt.show();
        }
        else if (type==2) {
            Attribute<Float> newAt = new Attribute<>();
            newAt.setAttribute(name,"float",key,required);
            newAt.setValue((Float)value);
            x[0]=type;
            x[1]=newAt;
            this.attributeList.addLast(x);
            newAt.show();
        }
        else if(type==3){
            Attribute<String> newAt = new Attribute<>();
            newAt.setAttribute(name,"String",key,required);
            newAt.setValue((String) value);
            x[0]=type;
            x[1]=newAt;
            this.attributeList.addLast(x);
            newAt.show();
        }
        else if(type==4) {
            Attribute<LocalDateTime> newAt = new Attribute<>();
            newAt.setAttribute(name,"Date", key, required);
            newAt.setValue((LocalDateTime) value);
            x[0]=type;
            x[1]=newAt;
            this.attributeList.addLast(x);
            newAt.show();
        }

    }
}
