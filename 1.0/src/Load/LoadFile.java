package Load;

import LinkedList.DoubleList.DoubleList;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.File;

public class LoadFile {

    //private JSONParser file;
    private String path;
    private DoubleList storeList;

    public LoadFile(String path){
       // this.file = new JSONParser();
        this.path = path;
        this.storeList = new DoubleList();


    }

    //http://lineadecodigo.com/java/listar-un-directorio-con-java/
    public void loadStores(){
        loadStores_aux();
    }

    private void loadStores_aux()
    {
        String directory = "C:\\Users\\geral\\Desktop\\LINKED";
        File store = new File(directory);
        if(store.exists())
        {
            File[] listF = store.listFiles();
            for (int i=0; i<listF.length;i++)
            {
                this.storeList.addLast(listF[i].getName());
            }
            //this.storeList.show();
        }
    }

    public DoubleList getStoreList() {
        return this.storeList;
    }
}
