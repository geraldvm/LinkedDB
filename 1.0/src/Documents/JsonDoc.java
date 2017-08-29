package Documents;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.*;


public class JsonDoc {

    private JSONObject storeJSON;
    private String store;

    private JSONObject attributteList;

    public JsonDoc (String store, JSONObject storeJSON){
        this.storeJSON = storeJSON;
        //this.attributteList = this.storeJSON.get("Store");
        this.store = store;
    }

    /*private JSONObject createAttribute(String name, int type, boolean key, boolean required)
    {

        if(attributteList.containsKey(name)==false) {
            System.out.println("El atributo ya existe");
        }
        else {
            JSONObject attribute = new JSONObject();
            attribute.put("Name",name);
            switch (type){
                case 1:
                    attribute.put("Type", "int");
                    break;
                case 2:
                    attribute.put("Type", "float");
                    break;
                case 3:
                    attribute.put("Type", "String");
                    break;
                case 4:
                    attribute.put("Type", "date");
                    break;
            }

            if (key==true){
                attribute.put("Key", "Primary");
            }
            else {
                attribute.put("Key", "Foreign");
            }

            attribute.put("Required", new Boolean(required));

            if (required==true){
                attribute.put("default", "default");
            }
            this.attributteList.put(name,attribute);
            this.storeJSON.replace(this.store,attributteList);

        }

    }*/


    public void createFile() {
        try {


            FileWriter file = new FileWriter("C:\\Users\\geral\\Desktop\\prueba.json");
            String conv = this.storeJSON.toJSONString();
            file.write(conv);
            file.flush();
            file.close();
        }

        catch(IOException e){
                //manejar error
        }
        System.out.println(this.storeJSON.toJSONString());

    }



}
