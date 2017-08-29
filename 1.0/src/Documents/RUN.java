package Documents;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class RUN {


    /*public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\geral\\Desktop\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            //jsonObject.get("Store2");
            //jsonObject.put("HELLO","NEHHH");
            //jsonObject.writeJSONString();
            //System.out.println(jsonObject);

            //System.out.println(jsonObject.get("Store2"));

            JSONObject attL = (JSONObject) jsonObject.get("Store2");
            JSONObject x = new JSONObject();
            x.put("Key","LOW");
            x.put("Type", "FEO");
            attL.replace("nameAT2",x);

            System.out.println(attL.keySet());
            JSONObject attS = (JSONObject) attL.get("nameAT2");



            jsonObject.replace("Store2",attL);
            //System.out.println(jsonObject);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/
}
