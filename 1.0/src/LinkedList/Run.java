package LinkedList;
import LinkedList.CircularList.CircularList;
import LinkedList.DoubleList.DoubleList;
import LinkedList.SimpleList.SimpleList;

public class Run {

    public static void main(String[] args) {

        SimpleList a = new SimpleList();

        System.out.println("*****************\n SimpleList");
        a.addLast(1);
        a.addLast("a");
        a.addLast("b");
        a.addLast("c");
        a.addLast("d");

        a.erase(1);
        a.erase("c");
        a.update("d","hello");

        //a.erase("hello");
        a.addLast("x");
        a.erase("x");
        a.show();

        //*********************************************************************
        System.out.println("*****************\n DoubleList");
        DoubleList b = new DoubleList();
        b.addFirst("e");
        b.addLast(5);
        b.addLast(6);
        b.show();
        // a.showReverse();
        System.out.println(b.search(25));
        b.search(23);

        //*********************************************************************
        System.out.println("*****************\n CircularDList");
        CircularList c = new CircularList();

        c.addLast(1);
        c.addLast(2);
        c.addLast(3);
        c.addLast(4);
        c.addLast(5);
        c.addLast(6);
        c.addLast(7);
        c.addLast(8);
        c.show();
        // a.showReverse();
        System.out.println(c.search(4));
        c.eraseLast();
        c.show();

        c.search(23);


    }
}