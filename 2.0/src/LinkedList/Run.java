package LinkedList;

public class Run {

    public static void main(String[] args) {

        Simple listaSimple = new Simple();
        listaSimple.addLast(1);
        listaSimple.addLast("b");
        listaSimple.addLast(3);
        listaSimple.addLast(3.0);
        listaSimple.show();
        listaSimple.erase("b");
        listaSimple.search(1);
        listaSimple.update(3, "hello");
        listaSimple.erase(3.0);
        listaSimple.erase(3.0);
        listaSimple.show();

    }

}
