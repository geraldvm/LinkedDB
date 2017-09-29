package Background.Commit;
import java.io.File;
import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;

public class SaveFiles {
    private DoubleList<Store> storeList;
    private String path;

    public SaveFiles(DoubleList<Store> storeList){
        this.storeList=storeList;
        this.path="C:\\Users\\geral\\Desktop\\LINKED\\";
    }
    public void createFile(){
        if (!this.storeList.isEmpty()) {
            for (int i = 0; i < this.storeList.length(); ++i) {
                this.createFile_aux(this.storeList.find(i).getItem());
            }
        }
        this.deleteFile();
    }
    private void createFile_aux(Store store)
    {
        //String path = System.getProperty("user.dir")+"\\STORES\\"+directory; //Directorio
        File newStore = new File(path+store.getStoreName());  //Crea el objeto
        newStore.mkdirs();
        for (int i=0;i<store.getDocs().length();++i){
            SaveDoc json = new SaveDoc(store.getStoreName(),
                    store.getDocs().find(i).getItem().getName(),
                    store.getDocs().find(0).getItem().getAttributeList(),
                    store.getDocs().find(0).getItem().getObjectList());
            json.createJSONFile();
        }

    }
    private void deleteFile(){
        File linkedDB = new File(path);
        File[] fileList = linkedDB.listFiles();
        for (int i=0;i<fileList.length;++i){
           if(!this.contains(fileList[i].getName())){
               if(fileList[i].isDirectory()) {

                   File directory = new File(path+fileList[i].getName()+"\\");
                   File[] archivos = directory.listFiles();
                   for (int n=0;n<archivos.length;++n){
                       archivos[n].delete();
                   }
                   directory.delete();
                   fileList[i].delete();
               }else{
                   fileList[i].delete();
               }
           }
        }

    }
    private boolean contains(String file){
        if (!this.storeList.isEmpty()) {
            for (int i = 0; i < this.storeList.length(); ++i) {
                if (file.equals(storeList.find(i).getItem().getStoreName())) {
                    return true;
                }
            }
            return false;
        }
        else {
            return false;
        }

    }
}
