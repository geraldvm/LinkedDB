package Load;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonLoad {

    public static JSONObject read(String storeName){
        String path = "C:\\Users\\geral\\Desktop\\LINKED\\"+storeName+"\\"+"Attributes.json";
        System.out.println(path);
        JSONParser parser = new JSONParser();
        try{

            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
            /*JSONObject attL = (JSONObject) jsonObject.get("ID");
            System.out.println(attL.toString());
            */

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*public JSONObject[] arrayJSON(){

    }*/

    public static void main(String[] args) {
        JSONObject z= read("StoreA");
        System.out.println(z.keySet().toArray().length);
        System.out.println(z.get(z.keySet().toArray()[0]));
    }





}
