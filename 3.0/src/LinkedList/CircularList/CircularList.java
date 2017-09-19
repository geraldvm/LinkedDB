package LinkedList.CircularList;

import Documents.JsonDoc;

public class CircularList {

    private Node first ;
    private Node last;
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



    public void addLast(JsonDoc item)
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
            Node newLast = new Node();
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
        Node temp = new Node();
        temp = last.getPrevious().getPrevious();
        last = last.getPrevious();
        last.setPrevious(temp);
        last.setNext(first);

    }
    public void show()
    {
        Node temp = first;

        while (temp.getNext() != first)
        {
            System.out.println(temp.getItem());
            temp = temp.getNext();
        }
        System.out.println(temp.getItem());
    }


    public Boolean search(JsonDoc item)
    {
        Node temp = first;
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

}