package Background.Load;

import Background.Documents.Attribute;
import Background.JsonObject.ObjectJSON;
import Background.LinkedList.SimpleList.SimpleList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonLoad {

    private String storeName;
    private String docName;

    public JsonLoad(String storeName, String docName){
        this.storeName=storeName;
        this.docName=docName;
    }

    public JSONObject read(){
        String path = "C:\\Users\\geral\\Desktop\\LINKED\\"+this.storeName+"\\"+this.docName+".json";
        System.out.println(path);
        JSONParser parser = new JSONParser();
        try{

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
    public SimpleList<Attribute> attributesREAD(){
        SimpleList<Attribute> attributeList = new SimpleList<>();
        JSONObject x = ((JSONObject) read().get("AttributeList"));
        Object[] at = x.keySet().toArray();
        if (at.length>0) {
            for (int i = 0; i < at.length; ++i) {
                JSONObject z = ((JSONObject) x.get(i));
                //String name, int type, boolean key,boolean required, Object value
                Attribute temp = new Attribute(((String) z.get("name")), ((String) z.get("type")),
                        ((boolean) z.get("key")), ((boolean) z.get("required")), z.get("value"));
                attributeList.addLast(temp);
            }
            return attributeList;
        }
        else {
            return null;
        }
    }

    public SimpleList<ObjectJSON> objectsREAD(){
        SimpleList<ObjectJSON> objectList = new SimpleList<>();
        JSONObject x = ((JSONObject) read().get("ObjectList"));
        Object[] obj = x.keySet().toArray();
        if (obj.length>0){
            for (int i=0;i<obj.length;++i){
                JSONObject z = ((JSONObject) x.get(i));
                ObjectJSON temp = new ObjectJSON(z.get("Attribute").toString(),z.get("Value"));
                objectList.addLast(temp);
            }
            return objectList;
        }
        else {
            return null;
        }


    }
    /*public JSONObject[] arrayJSON(){

    }*/

    public static void main(String[] args) {
        /*JSONObject z= read();
        System.out.println(z.keySet().toArray().length);
        System.out.println(z.get(z.keySet().toArray()[0]));
        */
    }





}
