package Background.Load;
import Background.Documents.JsonDoc;
import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;
import Background.LinkedList.CircularList.CircularList;
import java.io.File;

/**
 * Clase LoadFile
 * Busca los ficheros en memora=ia de una ruta
 * Carga los ficheros en listas
 * @author Gerald Valverde Mc kenzie
 * @version 7.0
 */
public class LoadFile {
    /**
     * Atributo
     * Lista Doblemente enlazada de Stores
     */
    private DoubleList<Store> storeList;

    /**
     * Constructor inicializa la lista
     */
    public LoadFile(){
        this.storeList = new DoubleList<>();
    }

    /**
     * Getter
     * @return Lista doblemente enlazada con datos de tipo Store
     */
    public DoubleList getStoreList() {
        return this.storeList;
    }

    /**
     * Metodo encargado de buscar en el directorio los store creados
     */
    public void loadStores(){
        this.loadStores_aux();
    }

    /**
     * Metodo que comprueba si un directorio existe en la ruta
     * @param directory ruta
     * @return array con los directorios en la ruta
     */
    public File[] exist(String directory)
    {
        return this.exist_aux(directory);
    }

    /**
     * Metodo que lee los documentos dentro de cada Store
     * @param store Store en el que va buscar
     * @return lista Circular con datos de tipo Store
     */
    private CircularList<JsonDoc> loadDocs(String store)
    {
        File[] listF = exist("LINKED\\"+store+"\\");
        CircularList<JsonDoc> docList = new CircularList<>();
        for (int i=0; i<listF.length;i++)
        {
            JsonDoc temp = new JsonDoc(listF[i].getName());
            JsonLoad readDoc = new JsonLoad(store,listF[i].getName());
            temp.setAttributeList(readDoc.getAttributeList());
            temp.setObjectList(readDoc.getObjectList());

            docList.addLast(temp);
        }
        return docList;
    }

    private void loadStores_aux()
    {
        File[] listF = exist("LINKED\\");
        for (int i=0; i<listF.length;i++)
        {
            Store temp= new Store(listF[i].getName(),this.loadDocs(listF[i].getName()));
            this.storeList.addLast(temp);
        }
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
