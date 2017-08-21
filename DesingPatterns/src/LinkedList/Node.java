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


    public Node getNext() {
        return next;
    }
}

public class NodeDouble extends Node{
    private NodeDouble previous;

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public NodeDouble getPrevious() {
        return previous;
    }
}