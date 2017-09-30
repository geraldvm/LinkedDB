package Background.Commit;
import java.io.File;
import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;

/**
 * Clase SaveFiles
 * Guarda los Stores en memoria fisica
 * @author Gerald Valverde Mc kenzie
 * version 7.0
 */
public class SaveFiles {
    /**
     * Atributos
     * Lista Doble de Store
     * Ruta de archivos
     */
    private DoubleList<Store> storeList;
    private String path;

    /**
     * Constructor
     * @param storeList: Recibe la lista de Store
     * Determina la ruta por defecto
     */
    public SaveFiles(DoubleList<Store> storeList){
        this.storeList=storeList;
        this.path="C:\\Users\\geral\\Desktop\\LINKED\\";
    }

    /**
     * Metodo encargado de crear las carpetas
     * o eliminarlas
     */
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
        File newStore = new File(path+store.getStoreName());
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

    /**
     * Boolean
     * @param file String
     * @return si existe la carpeta en el store
     */
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
