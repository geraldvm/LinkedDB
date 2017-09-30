package Background.Commit;
import java.io.*;
import Background.Documents.Attribute;
import Background.JsonObject.ObjectJ;
import Background.LinkedList.SimpleList.SimpleList;
import org.json.simple.JSONObject;

/**
 * Clase SaveDoc
 * Guarda los documentos en memoria fisica
 * @author Gerald Valverde Mc kenzie
 * @version 7.0
 */
public class SaveDoc {
    /**
     * Atributos
     */
    private String documentName;
    private String storeName;
    private SimpleList<Attribute> attribute;
    private SimpleList<ObjectJ> obj;
    private JSONObject jsonFile;
    private Object key;

    /**
     * Constructor
     * @param nameStore: Nombre del Store
     * @param nameDoc : nombre del documento
     * @param attribute : Lista de atributos
     * @param obj :lista de Objetos
     */
    public SaveDoc(String nameStore, String nameDoc, SimpleList<Attribute> attribute,SimpleList<ObjectJ> obj){
        this.storeName=nameStore;
        this.documentName=nameDoc;
        this.attribute=attribute;
        this.obj=obj;
        this.jsonFile= new JSONObject();

    }
    /**
     * Imprime el JSONObject creado
     */
    public void show(){
        System.out.println(this.jsonFile);
    }

    /**
     * Guarda en una ruta el documento
     */
    public void createJSONFile(){
        this.createJSONFile_aux();
    }

    /**
     * Agregar Objetos
     * Crea el JSONObject
     */
    public void addObject(){
        if (this.obj!=null){
            addObject_aux();
        }
    }

    /**
     * Crea el JSONObject de atributos
     */
    public void addAttribute(){
        this.addAttribute_aux();
    }

    private void addObject_aux(){
        JSONObject objList = new JSONObject();
        if(!this.obj.isEmpty()){
            JSONObject row = new JSONObject();
            for(int i=0;i<this.obj.length();++i){
                JSONObject objJson = new JSONObject();
                ObjectJ temp = this.obj.find(i).getItem();

                for (int x=0;x<temp.getRow().length();++x) {
                    objJson.put(temp.getRow().find(x).getItem().getColumn(),
                                temp.getRow().find(x).getItem().getValue());
                    if(temp.getRow().find(x).getItem().isPrimary()) {
                        this.key=temp.getRow().find(x).getItem().getValue();
                    }
                    row.put(i,objJson);
                }
            }
            this.jsonFile.put("ObjectList",row);
        }
    }


    private void addAttribute_aux(){
        JSONObject attribList = new JSONObject();
        if(!this.attribute.isEmpty()){
            for(int i=0;i<this.attribute.length();++i){
                JSONObject attribJson = new JSONObject();
                Attribute temp = this.attribute.find(i).getItem();
                attribJson.put("name",temp.getName());
                attribJson.put("type",temp.getType());
                attribJson.put("key",temp.getKey());
                attribJson.put("required", ((Boolean) temp.isRequired()));
                attribJson.put("value",temp.getValue());
                attribList.put(temp.getName(),attribJson);
            }
            this.jsonFile.put("AttributeList",attribList);
        }

    }


    public void createJSONFile_aux() {
        this.addAttribute();
        this.addObject();
        try {
            FileWriter file = new FileWriter("C:\\Users\\geral\\Desktop\\LINKED\\"+this.storeName+"\\"+this.documentName+".json");
            file.write(this.jsonFile.toJSONString());
            file.flush();
            file.close();
        }
        catch(IOException e){
        }
    }


}
