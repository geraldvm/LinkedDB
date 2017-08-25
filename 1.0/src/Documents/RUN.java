package Documents;

public class RUN {

    public static void main(String[] args) {
        JsonDoc a = new JsonDoc();
        a.createJson("tabla1", "ID",2, true,false);
        a.showJson();
        a.createFile();
    }
}
