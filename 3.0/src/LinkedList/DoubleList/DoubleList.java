package LinkedList.DoubleList;

import JsonStore.Store;

public class DoubleList{
    private Node first;
    private Node last;
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

    public Node find(int pos)
    {
        return find_aux(pos);
    }

    private Node find_aux(int pos)
    {
        Node temp = this.first;
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

    public void addFirst(Store item)
    {
        if (this.first == null)
        {
            this.first = new Node();
            this.first.setItem(item);
            this.last = this.first;
            this.size++;
        }
        else
        {
            Node newFirst = new Node();
            newFirst.setItem(item);
            newFirst.setNext(this.first);
            this.first.setPrevious(newFirst);
            this.first = newFirst;
            this.size++;
        }


    }

    public void addLast(Store item)
    {
        if (this.first == null)
        {
            this.last = new Node();
            this.last.setItem(item);
            this.first = this.last;
            this.size++;
        }
        else
        {
            Node newLast = new Node();
            newLast.setItem(item);
            newLast.setPrevious(last);
            last.setNext(newLast);
            last = newLast;
            this.size++;
        }
    }
    public void eraseLast()
    {
        last = last.getPrevious();
        if (first==null){
            System.out.println("lista vacia");
        }
        else if (last != null)
        {
            last.setNext(null);
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
        Node temp = this.first;
        while (temp != null)
        {
            System.out.println(temp.getItem());
            temp = temp.getNext();
        }
    }
    public void showReverse()
    {
        Node temp = last;
        while (temp != null)
        {
            System.out.println(temp.getItem());
            temp = temp.getPrevious();
        }
    }

    public Boolean search(Store item)
    {
        Node temp = this.first;
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