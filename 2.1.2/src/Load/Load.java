package Load;

import Documents.JsonDoc;
import JsonStore.Store;
import LinkedList.CircularList.CircularList;
import LinkedList.DoubleList.DoubleList;

import java.io.File;

public class Load{
    private DoubleList storeList;


    public Load(){
        this.storeList= new DoubleList();

    }

    public DoubleList getStoreList() {
        return this.storeList;
    }

    public void loadFiles(){
        loadFiles_aux();
    }

    private void loadFiles_aux(){

        File[] listS = exist("LINKED");
        for (int i=0; i<listS.length;i++) // Recorre el arreglo y lo mente en una lista enlazada
        {
            CircularList docList = new CircularList();
            File[] listD= exist("LINKED\\"+listS[i].getName());
            //System.out.println(listS[i].getName());
            for (int x=0;x<listD.length;x++){ //Carga los DOCS
                JsonDoc newDoc = new JsonDoc(listD[x].getName());
                docList.addLast(newDoc);
            }
            Store newSt = new Store(listS[i].getName(), docList);
            this.storeList.addLast(newSt);
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
}
