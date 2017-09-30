package Background.Documents;

import Background.JsonObject.ObjectJ;
import Background.LinkedList.SimpleList.SimpleList;
/**
 * Clase JsonDoc
 *Crea los documentos de LinkedDB
 * @author Gerald Valverde Mc kenzie
 * @version 7.0
 */
public class JsonDoc {
    /**
     * Atributos
     * Nombre del documento
     * Lista de atributos
     * Lista de Objetos
     */
    private String name;
    private SimpleList<Attribute> attributeList;
    private SimpleList<ObjectJ> objectList;

    /**
     * Constuctor
     * @param name: Nombre del documento
     */
    public JsonDoc(String name){
        this.name=name;
        this.attributeList=new SimpleList<>();
        this.objectList=new SimpleList<>();
    }

    /**
     * Constructor
     * @param name : nombre del documento
     * @param attributeList : Lista de Atributos
     * @param objectList: Lista de objetos
     */
    public JsonDoc (String name, SimpleList<Attribute> attributeList, SimpleList<ObjectJ> objectList){
        this.name=name;
        this.attributeList=attributeList;
        this.objectList=objectList;
    }

    /**
     * Getter
     * @return nombre del documento
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter
     * @return Lista de atributos
     */
    public SimpleList<Attribute> getAttributeList() {
        return this.attributeList;
    }

    /**
     * Crea un nuevo atributo
     * @param name : nombre del atributo
     * @param type : Tipo del atributo
     * @param key : (Primary=True)
     * @param required : Si es requerida
     */
    public void addAttribute(String name, int type, boolean key, boolean required){
        Attribute x = new Attribute(name,type, key, required);
        this.attributeList.addLast(x);
    }
    /**
     * Crea un nuevo atributo
     * @param name : nombre del atributo
     * @param type : Tipo del atributo
     * @param key : (Primary=True)
     * @param required : Si es requerida
     * @param value : valor por defecto
     */
    public void addAttribute(String name,int type, boolean key,boolean required,Object value){
        if(key) {
            Attribute x = new Attribute(name, type, key, required, value);
            this.attributeList.addFirst(x);
        }
        else {
            Attribute x = new Attribute(name, type, key, required, value);
            this.attributeList.addLast(x);
        }

    }

    /**
     * Crear Objetos
     * @param value: valor para cada columna
     */
    public void addObject(Object...value){
        ObjectJ x = new ObjectJ(this.attributeList);
        for(int i=0;i<value.length;++i){
            x.createRow(this.attributeList.findItem(i).getName(),value[i]);
        }
        this.objectList.addLast(x);

    }

    /**
     * Getter
     * @param pos: posicion en lista
     * @return atributo
     */
    public Attribute getAttributte(int pos){
        Attribute z = this.attributeList.findItem(pos);
        return z;
    }

    /**
     * Getter
     * @return lista de Objetos
     */
    public SimpleList<ObjectJ> getObjectList() {
        return this.objectList;
    }

    /**
     * Cambiar lista de atributos
     * @param attributeList
     */
    public void setAttributeList(SimpleList<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    /**
     * Cambiar lista de Objetos
     * @param objectList
     */
    public void setObjectList(SimpleList<ObjectJ> objectList) {
        this.objectList = objectList;
    }

}
