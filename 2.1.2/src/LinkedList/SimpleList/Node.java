package LinkedList.SimpleList;

public class Node {
    protected Object item;
    protected Node next;//private

    public Node(){
        this.next= null;
        this.item=null;
    }
    public Node(Object item, Node next){
        this.item=item;
        this.next=next;
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
        return this.next;
    }
}