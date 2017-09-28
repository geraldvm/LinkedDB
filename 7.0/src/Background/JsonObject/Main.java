package Background.JsonObject;

import Background.Documents.JsonDoc;

public class Main {
    public static void main(String[] args) {
        JsonDoc a = new JsonDoc("TEST");
        a.addAttribute("ID",1,true,true);
        a.addAttribute("FLOTANTES",2,false,false,2.85);
        a.addAttribute("name",3,false,false,"A");
        ObjectJ z = new ObjectJ(a.getAttributeList());
        z.createRow(12,58.3,"Carlos");

        for (int i=0;i<3;++i){
            //System.out.println(z.getRow().find(i).getItem().isPrimary());
        }

    }

}
