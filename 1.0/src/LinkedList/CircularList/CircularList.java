package LinkedList.CircularList;

import LinkedList.DoubleList.Node;

public class CircularList {

    private Node first ;
    private Node last;



    public void addLast(Object item)
    {
        if (first == null)
        {
            last = new Node();
            last.setItem(item);
            last.setNext(last);
            last.setPrevious(last);
            first = last;
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


    public Boolean search(Object item)
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

}