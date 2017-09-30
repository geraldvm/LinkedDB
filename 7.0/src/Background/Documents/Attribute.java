package Background.Documents;


/**
 * Clase Atributo
 * Cada una de las Columnas de las tablas de LinkedDB
 * @author Gerald Valverde Mc kenzie
 * @version  3.0
 */
public class Attribute {
    /**
     * Atributos
     */
    private String name;
    private String key;
    private boolean primary;
    private boolean required;
    private Object value;
    private String type;

    /**
     * Constructor
     * @param name : nombre del atributp
     * @param type : Tipo de dato
     * @param key   :(Primary=true)
     * @param required: valor requerido
     */
    public Attribute(String name, int type, boolean key,boolean required){
        this.name=name;
        this.type=type_aux(type);
        this.primary=key;
        this.key=compare(key);
        this.required=required;
        this.value=null;
    }

    public Attribute(String name, String type, String key,boolean required){
        this.name=name;
        this.type=type;
        this.key=key;
        this.required=required;
        this.value=null;
    }


    /**
     * Constructor
     * @param name : nombre del atributp
     * @param type : Tipo de dato (STRING)
     * @param key   : Primary or Foreign
     * @param required: valor requerido
     * @param value: valor por defecto
     */
    public Attribute(String name, String type, String key,boolean required, Object value){
        this.name=name;
        this.type=type;
        this.key=key;
        this.required=required;
        this.value=value;
        if(key.equals("Primary")){
            this.primary=true;
        }
    }

    /**
     * Constructor
     * @param name : nombre del atributp
     * @param type : Tipo de dato
     * @param key   :(Primary=true)
     * @param required: valor requerido
     * @param value : valor por defecto
     */
    public Attribute(String name, int type, boolean key,boolean required, Object value){
        this(name,type,key,required);
        this.setValue(value);
    }

    /**
     * Getter
     * @return tipo de dato
     */
    public String getType() {
        return this.type;
    }

    /**
     * Getter
     * @return valor por defecto
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * Getter
     * @return nombre del atributo
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter
     * @return Primary or Foreign
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Boolean
     * @return si es requerido
     */
    public boolean isRequired() {
        return this.required;
    }

    /**
     * Boolean
     * @return Primary=true
     */
    public boolean isPrimary() {
        return this.primary;
    }

    /**
     * Actualizar el valor por defecto
     * @param value: nuevo valor
     */
    public void setValue(Object value){
        if ((!this.required)&&(isSameType(value))){
            this.value=value;
        }

        else {
            this.value=null;
            System.out.println("ERROR");
        }
    }

    /**
     * Boolean to String
     * @param key
     * @return String
     */
    private String compare(boolean key){
        if (key==true){
            return  "Primary";
        }
        else {
            return "Foreign";
        }
    }

    /**
     * Casos de int to String
     * @param x
     * @return Strring
     */
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

    /**
     * Compara que el valor sea igual al tipo
     * @param value
     * @return true si son igual
     */
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

    /**
     * Mostrar valores
     */
    public void show(){
        System.out.println("name: "+this.name+" Key: "
                +this.key+ " Requerid: "+this.required+
                " Type: "+this.type+ " value: "+this.value);
    }




}
