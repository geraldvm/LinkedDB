package LinkedList.SimpleList;

public class Node {
    private Object item;
    private Node next;//private

    public Node(){
        this.next= null;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return this.item;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}