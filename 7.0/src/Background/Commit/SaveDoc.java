package Background.Commit;
import java.io.*;
import Background.Documents.Attribute;
import Background.JsonObject.ObjectJ;
import Background.JsonObject.ObjectJSON;
import Background.LinkedList.SimpleList.SimpleList;
import org.json.simple.JSONObject;

public class SaveDoc {
    private String documentName;
    private String storeName;
    private SimpleList<Attribute> attribute;
    private SimpleList<ObjectJ> obj;
    private JSONObject jsonFile;
    private Object key;

    public SaveDoc(String nameStore, String nameDoc, SimpleList<Attribute> attribute,SimpleList<ObjectJ> obj){
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
            JSONObject row = new JSONObject();
            for(int i=0;i<this.obj.length();++i){
                JSONObject objJson = new JSONObject();
                ObjectJ temp = this.obj.find(i).getItem();

                for (int x=0;x<temp.getRow().length();++x) {
                    objJson.put(temp.getRow().find(x).getItem().getColumn(),
                                temp.getRow().find(x).getItem().getValue());//Atrinuto valor
                    if(temp.getRow().find(x).getItem().isPrimary()) {
                        this.key=temp.getRow().find(x).getItem().getValue();
                    }
                    row.put(i,objJson);
                }//objList.put()
            }
            this.jsonFile.put("ObjectList",row);
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
    public void createJSONFile() {
        this.addAttribute();
        this.addObject();
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
