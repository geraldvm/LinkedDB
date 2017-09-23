package Background.LinkedList.SimpleList;

public class main {
    public static void main(String[] args) {

        SimpleList a = new SimpleList();

        System.out.println("*****************\n SimpleList");
        a.addLast(1);
        a.addLast("a");
        a.addLast("b");
        a.addLast("c");
        a.addLast("d");



        //a.erase("hello");
        a.addLast("x");
        a.show();
        a.search("b");
        System.out.println(a.find(0).getItem().getClass().getSimpleName());
    }
}
