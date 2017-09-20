package Load;

import Documents.Attribute;
import Documents.JsonDoc;
import JsonStore.Store;
import LinkedList.DoubleList.DoubleList;
import LinkedList.SimpleList.SimpleList;
import jdk.nashorn.internal.parser.JSONParser;
import LinkedList.CircularList.CircularList;
import org.json.simple.JSONObject;

import java.io.File;
import java.lang.reflect.Type;

public class LoadFile {

    //private JSONParser file;
    //private String path;
    private DoubleList<Store> storeList;
    private CircularList docList;

    public LoadFile(){
       // this.file = new JSONParser();
        this.storeList = new DoubleList<>();
        this.docList = new CircularList();


    }

    //http://lineadecodigo.com/java/listar-un-directorio-con-java/
    public void loadStores(){
        loadStores_aux();
    }

    public void loadDocs(){
        loadDocs_aux("StoreA");
    }



    private void loadStores_aux()
    {
        File[] listF = exist("Linked");
        for (int i=0; i<listF.length;i++) // Recorre el arreglo y lo mente eb una lista enlazada
        {
            Store temp= new Store(listF[i].getName(),null);
            this.storeList.addLast(temp);
            System.out.println(temp.getStoreName());
            this.loadDocs_aux(temp.getStoreName());


        }
        //this.storeList.show();
    }
    private void loadDocs_aux(String store)
    {

        File[] listF = exist("Linked\\"+store);
        for (int i=0; i<listF.length;i++) // Recorre el arreglo y lo mente eb una lista enlazada
        {
            //DEPURAR
            JsonDoc temp = new JsonDoc(listF[i].getName());
            this.docList.addLast(temp);
            System.out.println(temp.getName());
        }
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
    private SimpleList loadAttributeList(String docName){
        SimpleList<Attribute> attriList = new SimpleList<>();
        JsonLoad a = new JsonLoad();
        JSONObject x = a.read(docName);

        for (int i=0; i<x.keySet().toArray().length;++i){
            JSONObject at = ((JSONObject) x.get(x.keySet().toArray()[i]));
            Attribute newAttri = new Attribute(at.get("Name").toString(), ((int) at.get("Type")), ((boolean) at.get("Key")), ((boolean) at.get("Required")),at.get("Value"));
            attriList.addLast(newAttri);
        }
        return attriList;

    }

    public DoubleList getStoreList() {
        return this.storeList;
    }
}