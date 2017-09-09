/*package JsonStore;
import java.io.File;
import LinkedList.DoubleList.*;


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

        createCarpet_aux();

    }

    public DoubleList getRegistry()
    {
        return this.registry;
    }

    public void showRegistry()
    {
        this.registry.show();
    }

    private void createCarpet_aux()
    { //Crear Carpetas
        //String directory = "C:\\Users\\geral\\Documents\\PHOTO\\TEST";
        //Lee los stores en memoria fisica
        LoadFile storeMemory = new LoadFile("s");
        storeMemory.loadStores();
        DoubleList oldStore = storeMemory.getStoreList();
        Node temp;
        oldStore.show();
        System.out.println("//////////////////////////");

        for(int i=0;i<this.registry.length();i++)//Recorre la lista con cambios
        {
            temp = this.registry.find(i);

            /*System.out.println(temp.getItem());
            System.out.println(oldStore.search(temp.getItem()));
            */
/*
            if(!oldStore.search(temp.getItem()))//Si no existia ese store lo crea
            {
                System.out.println(temp.getItem());
                createCarpet_aux(temp.getItem().toString());
            }
            else
            {
                //System.out.println("errr");
                //System.out.println(temp.getItem());
            }

        }

    }
    private void createCarpet_aux(String directory)
    {
        //String path = System.getProperty("user.dir")+"\\STORES\\"+directory; //Directorio
        String path = "C:\\Users\\geral\\Desktop\\LINKED\\"+directory; //Directorio
        File newStore = new File(path); //Crea el objeto
        newStore.mkdirs();
    }

}*/