package Documents;

import jdk.nashorn.internal.parser.JSONParser;
import LinkedList.DoubleList.DoubleList;
import java.io.File;
import java.io.FileReader;

public class JSONRead {

    private JSONParser file;
    private String path;
    public DoubleList storeList;

    public JSONRead(String path){

    }

    //http://lineadecodigo.com/java/listar-un-directorio-con-java/
    private void loadStores(){
        String directory = "C:\\Users\\geral\\Desktop\\LINKED";
        File store = new File(directory);
        if(store.exists())
        {
            File[] listF = store.listFiles();
            for (int i=0; i<listF.length;i++)
            {
                this.storeList.addLast(listF[i].getName());
            }
        }
    }

}
