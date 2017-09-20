package LinkedList.SimpleList;

public class Node<T> {
    protected T item;
    protected Node<T> next;//private

    public Node(){
        this.next= null;
        this.item=null;
    }
    public Node(T item, Node<T> next){
        this.item=item;
        this.next=next;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }
}