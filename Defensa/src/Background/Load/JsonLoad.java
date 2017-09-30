package Background.Load;

import Background.Documents.Attribute;
import Background.JsonObject.ObjectJ;
import Background.LinkedList.SimpleList.SimpleList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase JsonLoad
 * Lectura de archivos JSON
 * Instanciacion de Objetos y Atributos
 * @author Gerald Valverde Mc kenzie
 * @version 7.0
 */
public class JsonLoad {
    /**
     * Atributos
     * Nombre del Store
     * Nombre del documento
     * Lista Simple de Atributos
     * Lista Simple de Objetos
     */
    private String storeName;
    private String docName;
    private SimpleList<Attribute> attributeList;
    private SimpleList<ObjectJ> objectList;


    /**
     * Constructor
     * Se inicializan variables
     * @param storeName nombre del store
     * @param docName nombre del docmuento a leer
     */
    public JsonLoad(String storeName, String docName) {
        this.storeName = storeName;
        this.docName = docName;
        this.attributeList=new SimpleList<>();
        this.objectList=new SimpleList<>();
    }

    /**
     * Metodo que llama a la lectura de los atributos del Doc
     * @return lista Simple de atributos
     */
    public SimpleList<Attribute> getAttributeList() {
        this.attributeREAD();
        return this.attributeList;
    }

    /**
     * Getter
     * @return Lista simple de Objetos
     */
    public SimpleList<ObjectJ> getObjectList() {
        this.objectsREAD();
        return this.objectList;
    }

    /**
     * Metodo encargado de leer el documento Json
     * @return JSONObject del documento leido
     */
    public JSONObject read(){
        return this.read_aux();
    }

    private JSONObject read_aux() {
        String path = System.getProperty("user.dir")+"\\LINKED\\" + this.storeName + "\\" + this.docName;
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void attributeREAD() {
        JSONObject x = (JSONObject) this.read().get("AttributeList");
        Object[] attKey = x.keySet().toArray();
        if (attKey.length > 0) {
            for (int i = 0; i < attKey.length; ++i) {
                JSONObject z = ((JSONObject) x.get(attKey[i]));
                Attribute temp = new Attribute(((String) z.get("name")), ((String) z.get("type")),
                        ((String) z.get("key")), ((boolean) z.get("required")), z.get("value"));
                if (z.get("key").equals("Primary")) {
                    this.attributeList.addFirst(temp);
                }else {
                    this.attributeList.addLast(temp);
                }
            }
        }
    }

   private void objectsREAD() {
       JSONObject x = ((JSONObject) read().get("ObjectList"));
       Object[] obj = x.keySet().toArray();
       if (obj.length > 0) {
           for (int i = 0; i < obj.length; ++i) {
               JSONObject z = ((JSONObject) x.get(obj[i]));
               ObjectJ newObj = new ObjectJ(this.attributeList);
               Object[] atributo = z.keySet().toArray();
               for(int n=0;n<atributo.length;++n){
                   newObj.createRowFromJson(atributo[n].toString(),z.get(atributo[n]));
               }
               this.objectList.addLast(newObj);
           }
       }
   }
    public static void main(String[] args) {}

}

