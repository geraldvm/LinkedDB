package Commit;
import java.io.*;
import Documents.Attribute;
import JsonObject.ObjectJSON;
import LinkedList.SimpleList.SimpleList;
import org.json.simple.JSONObject;

public class SaveDoc {
    private String documentName;
    private String storeName;
    private SimpleList<Attribute> attribute;
    private SimpleList<ObjectJSON> obj;
    private JSONObject jsonFile;


    public SaveDoc(String nameStore, String nameDoc, SimpleList<Attribute> attribute,SimpleList<ObjectJSON> obj){
        this.storeName=nameStore;
        this.documentName=nameDoc;
        this.attribute=attribute;
        this.obj=obj;
        this.jsonFile= new JSONObject();

    }
    public void addObject(){
        if (this.obj!=null){
            addObject_aux();
        }
    }

    private void addObject_aux(){
        //String name, int type, boolean key,boolean required, Object value
        JSONObject objList = new JSONObject();
        if(!this.obj.isEmpty()){
            for(int i=0;i<this.obj.length();++i){
                JSONObject objJson = new JSONObject();
                ObjectJSON temp = this.obj.find(i).getItem();
                objJson.put("Value",temp.getValue());
                objJson.put("Attribute",temp.getNameAttribute());
                objList.put(i,objJson);
            }
            this.jsonFile.put("ObjectList",objList);
        }
    }

    public void addAttribute(){
        //String name, int type, boolean key,boolean required, Object value
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
    public void show(){
        System.out.println(this.jsonFile);
    }
    public void createFile() {
        try {

            FileWriter file = new FileWriter("C:\\Users\\geral\\Desktop\\LINKED\\"+this.storeName+"\\"+this.documentName+".json");
            file.write(this.jsonFile.toJSONString());
            file.flush();
            file.close();
        }

        catch(IOException e){
            //manejar error
        }
    }


}
