package Commit;

import Documents.JsonDoc;

public class Main {
    public static void main(String[] args) {
        JsonDoc a = new JsonDoc("TEST");
        a.addAttribute("ID",1,true,false,89552);
        a.addAttribute("FLOTANTES",2,false,false,2.85);
        a.addAttribute("name",3,false,false,"454");
        //a.addAttribute("name",4,false,false,2017,02,45,9,20);
       SaveDoc x = new SaveDoc("TEST",a.getAttributeList(),null);
       x.addAttrib();
       //x.show();
        x.createFile();
    }
}
