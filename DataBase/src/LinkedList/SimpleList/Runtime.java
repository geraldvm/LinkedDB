package LinkedList.SimpleList;

public class Runtime {

    public static void main(String[] args) {
        LinkedListS ab = new LinkedListS();

        ab.addFirst("a");
        ab.addFirst(2);
        ab.addFirst("c");
        ab.addFirst(4.0);
        //ab.show();

        LinkedListS a = new LinkedListS();

        a.addLast(1);
        a.addLast("a");
        a.addLast("b");
        a.addLast("c");
        a.addLast("d");




        //a.show();
        //System.out.println("******************** \n");
        a.erase(1);
        a.erase("c");
        a.update("d","hello");
       // a.show();
       // System.out.println("+++++++++++++++++++++++++++++++++");
        a.erase("hello");
        a.addLast("x");
        a.show();


    }

}
