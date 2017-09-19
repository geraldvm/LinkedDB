package Documents;

import LinkedList.SimpleList.SimpleList;
import sun.net.www.content.text.Generic;

import java.lang.reflect.Type;

public class main {

    public void process(){

    }
    public static void main(String[] args) {
        JsonDoc h = new JsonDoc("doc1");
        h.addAtribute("ID", true, false, 1, 1252);
        h.addAtribute("name", false, true, 3, "gerald");
        SimpleList z = h.getAttributeList();
        Object[] status = ((Object[]) z.find(0).getItem());
        System.out.println(status[0]);
        if (status[0].equals(1)){
            Attribute<Integer> n =((Attribute<Integer>) status[1]);
            System.out.println(n.getType());
            n.show();
        }
        else if (status[0].equals(2)){
            Attribute<Float> n =((Attribute<Float>) status[1]);
        }
        else if (status[0].equals(3)){
            Attribute<String> n =((Attribute<String>) status[1]);
        }
        else if (status[0].equals(4)){
            Attribute<Integer> n =((Attribute<Integer>) status[1]);
        }



        //System.out.println(z.find(0).getItem().getClass());
        /*if (z.find(0).getItem() instanceof Integer){
            Attribute<Integer> a= z.find(0).getItem();
        }*/


        //a.show();
        //a.setValue("HELLO");
        //a.show();
    }
}
