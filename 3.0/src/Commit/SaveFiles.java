package Commit;
import java.io.File;
import JsonStore.Store;
import LinkedList.DoubleList.DoubleList;

public class SaveFiles {
    private DoubleList<Store> storeList;
    private Store z;

    public SaveFiles(DoubleList<Store> storeList){
        this.storeList=storeList;
    }
    private void createFile_aux(String storeName)
    {
        //String path = System.getProperty("user.dir")+"\\STORES\\"+directory; //Directorio
        String path = "C:\\Users\\geral\\Desktop\\LINKED\\"+storeName; //Directorio
        File newStore = new File(path); //Crea el objeto
        newStore.mkdirs();
        for (int i=0;i<z.getDocs().length();++i){
           // SaveDoc x = new SaveDoc(storeName,z.getDocs().find(i),)
            //FALTA
        }

    }
}
