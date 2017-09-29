package Background.Load;

import Background.Documents.Attribute;
import Background.Documents.JsonDoc;
import Background.JsonStore.Store;
import Background.LinkedList.SimpleList.SimpleList;
import Background.LinkedList.DoubleList.DoubleList;
import Background.LinkedList.CircularList.CircularList;
import org.json.simple.JSONObject;
import java.io.File;


public class LoadFile {

    //private JSONParser file;
    //private String path;
    private DoubleList<Store> storeList;
    //private CircularList<JsonDoc> docList;

    public LoadFile(){
       // this.file = new JSONParser();
        this.storeList = new DoubleList<>();
        //this.docList = new CircularList<>();


    }

    //http://lineadecodigo.com/java/listar-un-directorio-con-java/
    public void loadStores(){
        loadStores_aux();
    }
/*
    public void loadDocs(){
        loadDocs_aux("StoreA");
    }*/



    private void loadStores_aux()
    {
        File[] listF = exist("LINKED\\");
        for (int i=0; i<listF.length;i++) // Recorre el arreglo y lo mente eb una lista enlazada
        {
            Store temp= new Store(listF[i].getName(),this.loadDocs(listF[i].getName()));
            this.storeList.addLast(temp);
           //System.out.println(temp.getStoreName());
        }
        //this.storeList.show();
    }
    private CircularList<JsonDoc> loadDocs(String store)
    {

        File[] listF = exist("LINKED\\"+store+"\\");
        CircularList<JsonDoc> docList = new CircularList<>();
        for (int i=0; i<listF.length;i++) // Recorre el arreglo y lo mente eb una lista enlazada
        {

            JsonDoc temp = new JsonDoc(listF[i].getName());
            JsonLoad readDoc = new JsonLoad(store,listF[i].getName());
            temp.setAttributeList(readDoc.getAttributeList());
            temp.setObjectList(readDoc.getObjectList());

            docList.addLast(temp);

        }
        return docList;
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


    public DoubleList getStoreList() {
        return this.storeList;
    }
}
