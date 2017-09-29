package Background.Load;

import Background.Documents.Attribute;
import Background.JsonObject.ObjectJ;
import Background.JsonObject.ObjectJSON;
import Background.LinkedList.SimpleList.SimpleList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.management.AttributeList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonLoad {

    private String storeName;
    private String docName;
    private SimpleList<Attribute> attributeList;
    private SimpleList<ObjectJ> objectList;
   // private
    public static void main(String[] args) {
        /*System.out.println("ok");
        JsonLoad s=new JsonLoad("StoreA","DOC1");
        JSONObject z= read();
        System.out.println(z.keySet().toArray().length);
        System.out.println(z.get(z.keySet().toArray()[0]));
*/
    }

    public JsonLoad(String storeName, String docName) {
        this.storeName = storeName;
        this.docName = docName;
        this.attributeList=new SimpleList<>();
        this.objectList=new SimpleList<>();
    }

    public SimpleList<Attribute> getAttributeList() {
        this.attributeREAD();
        return this.attributeList;
    }

    public SimpleList<ObjectJ> getObjectList() {
        this.objectsREAD();
        return this.objectList;
    }

    public JSONObject read() {
        String path = "C:\\Users\\geral\\Desktop\\LINKED\\" + this.storeName + "\\" + this.docName;
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
                //String name, int type, boolean key,boolean required, Object value
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
               //System.out.println(z.toString());
               ObjectJ newObj = new ObjectJ(this.attributeList);
               Object[] atributo = z.keySet().toArray();
               for(int n=0;n<atributo.length;++n){
                   newObj.createRowFromJson(atributo[n].toString(),z.get(atributo[n]));
                   //newObj.showRowValue();
               }
               this.objectList.addLast(newObj);
           }
       }
   }
   /*private void addObject(Object...value) {
       ObjectJ x = new ObjectJ(this.attributeList);
       for (int i = 0; i < value.length; ++i) {
           x.createRow(this.attributeList.find(i).getItem().getName(), value[i]);
       }
       this.objectList.addLast(x);
   }*/



    /*public JSONObject[] arrayJSON(){

    }*/

}





//}
