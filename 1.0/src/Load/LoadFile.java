package Load;

import LinkedList.DoubleList.DoubleList;
import jdk.nashorn.internal.parser.JSONParser;
import LinkedList.CircularList.CircularList;

import java.io.File;

public class LoadFile {

    //private JSONParser file;
    private String path;
    private DoubleList storeList;
    private CircularList docList;

    public LoadFile(String path){
       // this.file = new JSONParser();
        this.path = path;
        this.storeList = new DoubleList();
        this.docList = new CircularList();
    }

    public DoubleList getStoreList() {
        return this.storeList;
    }

    public CircularList getDocList() {
        return this.docList;
    }

    //http://lineadecodigo.com/java/listar-un-directorio-con-java/
    public void loadStores(){
        loadStores_aux();
    }

    private void loadStores_aux()
    {
        File[] listF = exist("Linked");
        for (int i=0; i<listF.length;i++) // Recorre el arreglo y lo mente eb una lista enlazada
        {
            this.storeList.addLast(listF[i].getName());
        }
        //this.storeList.show();
    }

    public void loadDocs(String store){
        loadDocs_aux(store);
    }

    private void loadDocs_aux(String store)
    {
        File[] listF = exist("Linked"+store);
        for (int i=0; i<listF.length;i++) // Recorre el arreglo y lo mente eb una lista enlazada
        {
            this.docList.addLast(listF[i].getName());
        }
        //this.storeList.show();
    }

    public File[] exist(String directory)
    {
        return exist_aux(directory);
    }

    private File[] exist_aux(String directory)
    {
        String path = "C:\\Users\\geral\\Desktop\\"+directory;
        File store = new File(path);
        if (store.exists())
        {
            File[] listF = store.listFiles();
            return listF;
        }
        return  null;
    }


}
