package LinkedList.DoubleList;

import JsonStore.Store;

public class Node {
    private Node previous;
    private Node next;
    private Store item;

    public Node(){
        this.previous=null;
        this.next=null;
        this.item=null;
    }

    public void setItem(Store item) {
        this.item = item;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Store getItem() {
        return this.item;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }
}