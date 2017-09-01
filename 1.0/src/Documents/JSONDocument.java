package Documents;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.*;


public class JSONDocument {
    private String store;
    private String name;
    private JSONObject JSONDoc;

    public JSONDocument (String store, String name){
        this.store = store;
        this.name = name;
        this.JSONDoc = new JSONObject();
    }

    public void createAttribute(String name, int type, boolean key, boolean required){
        createAttribute_aux(name,type,key,required);
    }

    private void createAttribute_aux(String name, int type, boolean key, boolean required)
    {

        JSONObject attribute = new JSONObject();
        attribute.put("Name",name);

        attribute.put("Type", type_aux(type));


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

        if(update(name)){
            this.JSONDoc.replace(name,attribute);
        }
        else{
            this.JSONDoc.put(name,attribute);
        }
    }
    private String type_aux (int x){
        String type = "";
        switch (x){
            case 1:
                type = "int";
                break;
            case 2:
                type = "float";
                break;
            case 3:
                type = "String";
                break;
            case 4:
                type = "date";
                break;
        }
        return type;
    }

    private boolean update(String name){
        Object[] attributeList = this.JSONDoc.keySet().toArray();
        for(int i=0;i<attributeList.length;i++){
            if (attributeList[i].toString().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void createFile()
    {
        createFile_aux();
    }

    private void createFile_aux() {
        try {
            FileWriter file = new FileWriter("C:\\Users\\geral\\Desktop\\LINKED\\"+this.store+"\\"+this.name+".json");
            file.write(this.JSONDoc.toJSONString());
            file.flush();
            file.close();
        }
        catch(IOException e){
            //manejar error
        }
        System.out.println(this.JSONDoc.toJSONString());
    }

}