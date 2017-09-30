package Background.JsonObject;
/**
 * Clase Objeto
 *Crea instancias de tipo Objeto
 * @author Gerald Valverde Mc kenzie
 * @version 7.0
 */
public class Objeto {
    /**
     * Atributos
     * column: atributos
     * value: valor
     * type: tipo de objeto
     * key: (Primary, Foreign)
     */
    private String column;
    private Object value;
    private String type;
    private boolean key;

    /**
     * Costructor
     * @param column : atributo
     * @param type : tipo de Objeto
     * @param key : (Primary, Foreign)
     * @param value : valor
     */
    public Objeto(String column,String type, boolean key,Object value){
        this.column=column;
        this.type=type;
        this.key=key;
        this.value=value;
    }

    /**
     * Setter
     * @param value nuevo valor
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Getter
     * @return value
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * Boolean
     * @return si es primario
     */
    public boolean isPrimary() {
        return this.key;
    }

    /**
     * Getter
     * @return nombre del atributo
     */
    public String getColumn() {
        return this.column;
    }

    /**
     * Getter
     * @return tipo de dato
     */
    public String getType() {
        return this.type;
    }
}
