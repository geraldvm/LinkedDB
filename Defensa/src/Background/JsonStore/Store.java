package Background.JsonStore;

import Background.Documents.JsonDoc;
import Background.LinkedList.CircularList.CircularList;

/**
 * Clase Store
 *Crea instancias de tipo Store
 * @author Gerald Valverde Mc kenzie
 * @version 7.0
 */
public class Store {
    /**
     * Atributos
     * Nombre del Store
     * Lista de documentos
     */
    private String storeName;
    private CircularList<JsonDoc> docs;

    /**
     * Constructor
     * @param storeName nombre del Store
     */
    public Store (String storeName){
        this.storeName=storeName;
        this.docs=new CircularList<>();
    }

    /**
     * Constructor
     * @param storeName nombre del Store
     * @param docs Lista de documentos
     */
    public Store(String storeName, CircularList docs){
        this.storeName=storeName;
        this.docs= docs;
    }

    /**
     * Reemplazar lista de documentos
     * @param docs lista circular
     */
    public void setDocs(CircularList docs) {
        this.docs = docs;
    }

    /**
     * Cambiar el nombre del Store
     * @param storeName nombre
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Getter
     * @return lista de documentos
     */
    public CircularList<JsonDoc> getDocs() {
        return this.docs;
    }

    /**
     * Getter
     * @return nombre de Store
     */
    public String getStoreName() {
        return this.storeName;
    }

    /**
     * Crear un nuevo Documento
     * @param name nombre del documento
     */
    public void newDoc(String name){
        JsonDoc a = new JsonDoc(name);
        this.docs.addLast(a);
    }

    /**
     * Agrega un nuevo Documento
     * @param doc nombre del documento
     */
    public void newDoc(JsonDoc doc){
        this.docs.addLast(doc);
    }

    /**
     * Agregar Atributos
     * @param jsonDoc JsonDoc
     * @param name nombre del atributo
     * @param type tipo del atributo
     * @param key llave del atributo
     * @param required si el atributo es requerido
     * @param value valor por defecto
     */
    public void addAtrribute(JsonDoc jsonDoc,String name,int type, boolean key, boolean required, Object value){
        jsonDoc.addAttribute(name,type,key,required,value);
    }
    /**
     * Agregar Atributos sin valor por defecto
     * @param jsonDoc JsonDoc
     * @param name nombre del atributo
     * @param type tipo del atributo
     * @param key llave del atributo
     * @param required si el atributo es requerido
     */
    public void addAtrribute(JsonDoc jsonDoc,String name,int type, boolean key, boolean required){
        jsonDoc.addAttribute(name,type,key,required);
    }

    /**
     * Busqueda de Documentos por su nombre
     * @param name nombre del documento
     * @return JsonDoc
     */
    public JsonDoc getDoc(String name){
        return this.getDoc_aux(name);
    }

    /**
     * Borrar Documento
     * @param name nombre del documento a borrar
     */
    public void eraseDoc(String name){
        this.eraseDoc_aux(name);
    }

    private JsonDoc getDoc_aux(String name){
        for (int i=0;i<this.docs.length();i++){
            if (this.docs.find(i).getItem().getName()==name){
                return this.docs.find(i).getItem();
            }
        }
        return null;
    }


    private void eraseDoc_aux(String name) {
        for (int i=0;i<this.docs.length();++i){
            if (this.docs.find(i).getItem().getName()==name){
                this.docs.deletePos(i);
            }
        }
    }


}
