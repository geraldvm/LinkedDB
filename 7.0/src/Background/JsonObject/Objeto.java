package Background.JsonObject;

public class Objeto {
    private String column;
    private Object value;
    private String type;
    private boolean key;
    public Objeto(String column,String type, boolean key,Object value){
        this.column=column;
        this.type=type;
        this.key=key;
        this.value=value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isPrimary() {
        return this.key;
    }

    public String getColumn() {
        return this.column;
    }

    public String getType() {
        return this.type;
    }
}
