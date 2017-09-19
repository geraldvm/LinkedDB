package Documents;

public class docRun {
    public static void main(String[] args) {
        JsonDoc a = new JsonDoc("TEST");
        a.addAttribute("ID",1,true,true);
        a.addAttribute("FLOTANTES",2,false,false,2.85);
        a.addAttribute("name",3,false,false,"A.");
        //a.addAttribute("name",4,false,false,2017,02,45,9,20);
        a.addObject(a.getAttributte(1),152);
    }
}
