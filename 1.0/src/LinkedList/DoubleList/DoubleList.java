package LinkedList.DoubleList;

public class DoubleList {
    private Node first;
    private Node last;

    public void addFirst(Object item)
    {
        if (first == null)
        {
            first = new Node();
            first.setItem(item);
            last = first;
        }
        else
        {
            Node newFirst = new Node();
            newFirst.setItem(item);
            newFirst.setNext(first);
            first.setPrevious(newFirst);
            first = newFirst;
        }


    }

    public void addLast(Object item)
    {
        if (first == null)
        {
            last = new Node();
            last.setItem(item);
            last.setNext();
            last.setPrevious();
            first = last;
        }
        else
        {
            Node newLast = new Node();
            newLast.setItem(item);
            newLast.setPrevious(last);
            last.setNext(newLast);
            last = newLast;
        }
    }
    public void eraseLast()
    {
        last = last.getPrevious();
        if (last != null)
        {
            last.setNext(null);
        }
        else
        {
            first = null;
        }
    }
    public void show()
    {
        Node temp = first;
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

    public Boolean search(Object item)
    {
        Node temp = first;
        while (temp != null)
        {
            if (temp.getItem()==item)
            {
                return true;
            }
            temp =temp.getNext();
        }
        return false;
    }
}