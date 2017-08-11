package Test;
import java.io.File;

public class JsonStore {
    private String name; //Nombre de la carpeta

    public void setName(String name) {
        this.name = name;
        this.create();

    }
    public String getName()
    {
        return name;
    }

    private void create()
    { //Crear Carpetas
        //String directory = "C:\\Users\\geral\\Documents\\PHOTO\\TEST";
        String directory = System.getProperty("user.dir")+"\\"+this.getName(); //Directorio
        File newStore = new File(directory); //Crea el objeto
        newStore.mkdirs();
    }

}
