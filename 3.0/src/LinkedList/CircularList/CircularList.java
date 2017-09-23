package LinkedList.CircularList;
import LinkedList.DoubleList.Node;

public class CircularList<T> {

    private Node<T> first ;
    private Node<T> last;
    private int size;

    public CircularList()
    {
        this.first=null;
        this.last=null;
        this.size=0;
    }

    public int length() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.first==null;
    }



    public void addLast(T item)
    {
        if (first == null)
        {
            last = new Node();
            last.setItem(item);
            last.setNext(last);
            last.setPrevious(last);
            first = last;
            ++this.size;
        }
        else
        {
            Node<T> newLast = new Node();
            newLast.setItem(item);
            newLast.setPrevious(last);
            newLast.setNext(first);
            last.setNext(newLast);
            first.setPrevious(newLast);
            last = newLast;
            ++this.size;
        }
    }
    public void eraseLast()
    {
        Node<T> temp = new Node();
        temp = last.getPrevious().getPrevious();
        last = last.getPrevious();
        last.setPrevious(temp);
        last.setNext(first);

    }
    public void show()
    {
        Node<T> temp = first;

        while (temp.getNext() != first)
        {
            System.out.println(temp.getItem());
            temp = temp.getNext();
        }
        System.out.println(temp.getItem());
    }


    public Boolean search(Object item)
    {
        Node<T> temp = first;
        while (temp.getNext() != first)
        {
            if (temp.getItem()==item)
            {
                return true;
            }
            temp =temp.getNext();
        }
        if (temp.getItem()==item)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public Node<T> find(int pos)
    {
        return find_aux(pos);
    }

    private Node<T> find_aux(int pos)
    {
        Node<T> temp = this.first;
        if(this.isEmpty())
        {
            return null;
        }
        else {
            if (pos <= this.length())
            {
                for (int i=0; i<pos; i++)
                {
                    temp= temp.getNext();
                }
                return temp;

            }
            return null;
        }
    }

}