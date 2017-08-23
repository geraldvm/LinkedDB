package JsonStore;
import java.io.File;
import LinkedList.DoubleList.DoubleList;

public class JsonStore {
    private DoubleList registry = new DoubleList();
    private String name; //Nombre de la carpeta



    private void setRegistry(DoubleList registry) {
        this.registry = registry;
    }



    public void setName(String name) {
        this.name = name;
        this.create(name);

    }
    public String getName()
    {
        return name;
    }
    public void getStores()
    {
        registry.show();
    }

    private boolean create(String name)
    { //Crear Carpetas
        //String directory = "C:\\Users\\geral\\Documents\\PHOTO\\TEST";
        if (this.registry.search(name)){
            System.out.println("ERROR Escoja otro Nombre");
            return false;
        }
        else
        {
            this.registry.addLast(name);
            String directory = System.getProperty("user.dir")+"\\"+name; //Directorio
            File newStore = new File(directory); //Crea el objeto
            newStore.mkdirs();
            return true;
        }


    }

}
