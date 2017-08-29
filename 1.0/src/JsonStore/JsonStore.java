package JsonStore;
import java.io.File;
import LinkedList.DoubleList.DoubleList;

import javax.jws.soap.InitParam;
import Load.LoadFile;

public class JsonStore {
    private DoubleList registry;
    //private String name; //Nombre de la carpeta


    public JsonStore(DoubleList registry)
    {
        this.registry = registry;
        //Constructor se carga los la lista de Store
    }

    public void setRegistry(DoubleList registry)
    {
        this.registry = registry;
    }

    public void addStore(String name)
    {
        if(this.registry.search(name))
        {
            System.out.println("ERROR: THIS NAME ALREADY");
        }
        else {
            this.registry.addLast(name);

        }

    }

    public void createCarpet() {
        //name nombre de la carpeta
        this.createCarpet_aux();

    }

    public DoubleList getRegistry()
    {
        return this.registry;
    }

    public void showRegistry()
    {
        this.registry.show();
    }

    private boolean createCarpet_aux(String name)
    { //Crear Carpetas
        //String directory = "C:\\Users\\geral\\Documents\\PHOTO\\TEST";
        LoadFile storeMemory = new LoadFile("s");
        storeMemory.loadStores();
        JsonStore oldStore = new JsonStore(storeMemory.getStoreList());
        /*if(oldStore.tiene(registry.getitem))
            else
                */
        if (this.registry.search(name)){
            System.out.println("ERROR Escoja otro Nombre");
            return false;
        }
        else
        {
            //String directory = System.getProperty("user.dir")+"\\"+name; //Directorio
            String directory = System.getProperty("C:\\Users\\geral\\Desktop\\LINKED"+name); //Directorio
            File newStore = new File(directory); //Crea el objeto
            newStore.mkdirs();
            return true;
        }


    }

}