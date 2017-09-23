package Background.LinkedList.DoubleList;

import Background.JsonStore.Store;

public class DoubleList<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;

    public DoubleList()
    {
        this.first=null;
        this.last=null;
        this.size=0;
    }


    public int length() {
        return this.size;
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
    public boolean isEmpty(){
        return this.first==null;
    }

    public void addFirst(T item)
    {
        if (this.first == null)
        {
            this.first = new Node<>();
            this.first.setItem(item);
            this.last = this.first;
            this.size++;
        }
        else
        {
            Node<T> newFirst = new Node<>();
            newFirst.setItem(item);
            newFirst.setNext(this.first);
            this.first.setPrevious(newFirst);
            this.first = newFirst;
            this.size++;
        }


    }

    public void addLast(T item)
    {
        if (this.first == null)
        {
            this.last = new Node<T>();
            this.last.setItem(item);
            this.first = this.last;
            this.size++;
        }
        else
        {
            Node<T> newLast = new Node<>();
            newLast.setItem(item);
            newLast.setPrevious(this.last);
            this.last.setNext(newLast);
            this.last = newLast;
            this.size++;
        }
    }
    public void eraseLast()
    {
        this.last = this.last.getPrevious();
        if (this.first==null){
            System.out.println("lista vacia");
        }
        else if (this.last != null)
        {
            this.last.setNext(null);
            this.size--;
        }
        else
        {
            this.first = null;
            this.size--;
        }
    }
    public void show()
    {
        Node<T> temp = this.first;
        while (temp != null)
        {
            System.out.println(temp.getItem());
            temp = temp.getNext();
        }
    }


    public Boolean search(T item)
    {
        Node<T> temp = this.first;
        while (temp != null)
        {
            if (temp.getItem().equals(item))
            {
                return true;
            }
            temp =temp.getNext();
        }
        return false;
    }


}