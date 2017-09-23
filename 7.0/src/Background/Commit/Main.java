package Background.Commit;

import Background.Documents.JsonDoc;

public class Main {
    public static void main(String[] args) {
        JsonDoc a = new JsonDoc("TEST");
        a.addAttribute("ID",1,true,false,89552);
        a.addAttribute("FLOTANTES",2,false,false,2.85);
        a.addAttribute("name",3,false,false,"454");
        //a.addAttribute("name",4,false,false,2017,02,45,9,20);
        a.addObject("ID",455);
        a.addObject("FLOTANTES",455);
        a.addObject("name","TEST");
        SaveDoc x = new SaveDoc("StoreA","TEST",a.getAttributeList(),a.getObjectList());
        x.addAttribute();
        x.addObject();
        x.show();
        x.createFile();
    }
}
