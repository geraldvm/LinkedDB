package JsonObject;

import Documents.Attribute;

public class ObjectJSON {
    private Attribute attr;
    private Object value;
    private String nameAttr;

    public ObjectJSON(Attribute Attr,Object value){
        this.attr=Attr;
        this.nameAttr=this.attr.getName();
        setObject(value);
    }

    public void setObject(Object value){
        if(isSameType(value)){
            this.value=value;
        }
    }

    private boolean isSameType(Object value){
        String x = value.getClass().getSimpleName();

        switch (x){
            case "Integer":
                return this.attr.getType()=="int";
            case "Double":
                return this.attr.getType()=="float";
            case "String":
                return this.attr.getType()=="String";
            case "LocalDateTime":
                return this.attr.getType()=="date";
            default:
                System.out.println("DEFAULT");
                return false;
        }

    }
    public void show(){
        System.out.println(this.value);
    }




}
