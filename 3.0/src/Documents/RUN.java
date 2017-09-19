package Documents;




public class RUN {

    public static void main(String[] args) {
        JSONDocument a = new JSONDocument("StoreA","Tabla1");
        a.createAttribute("ID",2,true,false);
       // a.createAttribute("name",1,false,true);
        a.createAttribute("name",2,true,false);

        a.createFile();



    }


}
