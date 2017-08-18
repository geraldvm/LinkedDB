package LinkedList;

public class Node {
    private Object item;
    private Node next;//private



    public void setItem(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setNext(){
        this.next = null;
    }

    public Node getNext() {
        return next;
    }
}
