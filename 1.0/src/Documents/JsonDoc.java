package Documents;

import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.*;


public class JsonDoc {

    private JSONObject newAt= new JSONObject();



    public void create(){

    }

    public void createJson(String store,String name, int type, boolean key, boolean required)
    {

        this.newAt.put("Store",store);
        this.newAt.put("Name",name);
        switch (type){
            case 1:
                this.newAt.put("Type", "int");
                break;
            case 2:
                this.newAt.put("Type", "float");
                break;
            case 3:
                this.newAt.put("Type", "String");
                break;
            case 4:
                this.newAt.put("Type", "date");
                break;
        }

        if (key==true){
            this.newAt.put("Key", "Primary");
        }
        else {
            this.newAt.put("Key", "Foreign");
        }

        this.newAt.put("Required", new Boolean(required));

        if (required==true){
            this.newAt.put("default", "default");
        }


    }

    public void showJson(){
        System.out.println(this.newAt);
    }

    public void createFile() {
        try {


            FileWriter file = new FileWriter("C:\\Users\\geral\\Desktop\\prueba.json");
            String conv = this.newAt.toJSONString();
            file.write(conv);
            file.flush();
            file.close();
        }

        catch(IOException e){
                //manejar error
        }

    }

}
