package Background.LinkedList.DoubleList;
public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T item;

    public Node(){
        this.previous=null;
        this.next=null;
        this.item=null;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getItem() {
        return this.item;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public Node<T> getNext() {
        return next;
    }
}