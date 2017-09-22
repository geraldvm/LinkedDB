package Commit;

import Documents.Attribute;
import JsonObject.ObjectJSON;
import LinkedList.SimpleList.SimpleList;
import org.json.simple.JSONObject;

public class SaveDoc {
    private String nameDoc;
    private SimpleList<Attribute> attribute;
    private SimpleList<ObjectJSON> obj;
    private JSONObject jsonFile;

    public SaveDoc(String nameDoc, SimpleList<Attribute> attribute,SimpleList<ObjectJSON> obj){
        this.nameDoc=nameDoc;
        this.attribute=attribute;
        this.obj=obj;
        this.jsonFile= new JSONObject();
        System.out.println(this.attribute.length());

    }

    public void addAttrib(){
        //String name, int type, boolean key,boolean required, Object value
        JSONObject attribList = new JSONObject();
        if(!this.attribute.isEmpty()){
            JSONObject attribJson = new JSONObject();
            for(int i=0;i<this.attribute.length();++i){
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
}
