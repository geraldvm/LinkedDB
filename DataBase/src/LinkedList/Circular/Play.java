package LinkedList.Circular;

public class Play {

    public static void main(String[] args) {
        DoubleCircular a = new DoubleCircular();

        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        a.addLast(7);
        a.addLast(8);
        a.show();
        // a.showReverse();
        System.out.println(a.search(4));
        a.eraseLast();
        a.show();

        a.search(23);


    }
}
