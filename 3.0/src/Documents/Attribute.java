package Documents;

import java.time.LocalDateTime;

public class Attribute {

    private String name;
    private String key;
    private boolean required;
    private Object value;
    private String type;

    public Attribute(String name, int type, boolean key,boolean required){
        this.name=name;
        this.type=type_aux(type);
        this.key=compare(key);
        this.required=required;
        this.value=null;

    }

    public Attribute(String name, int type, boolean key,boolean required, Object value){
        this(name,type,key,required);
        this.setValue(value);
    }
    /*public Attribute(String name, int type, boolean key,boolean required,int year, int month, int day, int hour, int min ){
        this(name, type, key, required);
        if (!isRequired()&&this.type=="date"){
            setValue(year, month, day, hour, min);
        }
    }*/

    public String getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setAttribute(String name, String type, boolean key,boolean required){
        this.name=name;
        this.type= type;
        this.key=compare(key);
        this.required = required;
    }

    public void setValue(Object value){
        if (!this.required&&isSameType(value)){
            this.value=value;
        }

        else {
            this.value=null;
            System.out.println("ERROR");
        }
    }
    /*private void setValue(int year, int month, int day, int hour, int min){
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, min);
        this.value=date;
    }*/

    private String compare(boolean key){
        if (key==true){
            return  "Primary";
        }
        else {
            return "Foreign";
        }
    }

    private String type_aux (int x){
        String type = "";
        switch (x){
            case 1:
                type = "int";
                break;
            case 2:
                type = "float";
                break;
            case 3:
                type = "String";
                break;
            case 4:
                type = "date";
                break;
        }
        return type;
    }


    private boolean isSameType(Object value){
        String x = value.getClass().getSimpleName();

        switch (x){
            case "Integer":
                System.out.println(this.type=="int");
                return this.type=="int";
            case "Double":
                System.out.println(this.type=="float");
                return this.type=="float";
            case "String":
                System.out.println(this.type=="String");
                return this.type=="String";
            case "LocalDateTime":
                System.out.println(this.type=="date");
                return this.type=="date";
            default:
                System.out.println("DEFAULT");
                return false;
        }

    }

    public void show(){
        System.out.println("name: "+this.name+" Key: "
                +this.key+ " Requerid: "+this.required+
                " Type: "+this.type+ " value: "+this.value);
    }


}
