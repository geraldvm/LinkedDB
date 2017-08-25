package LinkedList.DoubleList;

public class Node {
    private Node previous;
    private Node next;
    private Object item;

    public void setItem(Object item) {
        this.item = item;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setPrevious()
    {
        this.previous = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setNext()
    {
        this.next = null;
    }

    public Object getItem() {
        return item;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }
}