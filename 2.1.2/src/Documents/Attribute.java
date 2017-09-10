package Documents;

public class Attribute<T> {

    private String name;
    private String key;
    private boolean required;
    private T value;
    private String type;

    public Attribute(){
        this.name = null;
        this.key=null;
        this.type= null;
    }
    public void setAttribute(String name, String type, boolean key,boolean required){
        this.name=name;
        this.type= type;
        compare(key);
        this.required= required;
    }

    public void setValue(T value){
        if (!required){
            this.value=value;
        }

        else {
            this.value=null;
        }
    }

    private void compare(boolean key){
        if (key==true){
            this.key= "Primary";
        }
        else {
            this.key="Foreign";
        }
    }
    public void show(){
        System.out.println("name: "+this.name+" Key: "+this.key+ " Requerid: "+this.required+" Type: "+this.type+ " value: "+this.value);
    }

    public String getType() {
        return this.type;
    }
}
