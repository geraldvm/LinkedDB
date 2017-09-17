package LinkedList.DoubleList;

import JsonStore.Store;

public class DoubleList{
    private NodeD first;
    private NodeD last;
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

    public NodeD find(int pos)
    {
        return find_aux(pos);
    }

    private NodeD find_aux(int pos)
    {
        NodeD temp = this.first;
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
        if (first == null)
        {
            first = new NodeD();
            first.setItem(item);
            last = first;
            this.size++;
        }
        else
        {
            NodeD newFirst = new NodeD();
            newFirst.setItem(item);
            newFirst.setNext(first);
            first.setPrevious(newFirst);
            first = newFirst;
            this.size++;
        }


    }

    public void addLast(Store item)
    {
        if (first == null)
        {
            last = new NodeD();
            last.setItem(item);
            first = last;
            this.size++;
        }
        else
        {
            NodeD newLast = new NodeD();
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
            first = null;
            this.size--;
        }
    }
    public void show()
    {
        NodeD temp = first;
        while (temp != null)
        {
            System.out.println(temp.getItem());
            temp = temp.getNext();
        }
    }
    public void showReverse()
    {
        NodeD temp = last;
        while (temp != null)
        {
            System.out.println(temp.getItem());
            temp = temp.getPrevious();
        }
    }

    public Boolean search(Store item)
    {
        NodeD temp = first;
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