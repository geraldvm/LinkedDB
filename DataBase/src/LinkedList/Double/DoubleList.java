package LinkedList.Double;

public class DoubleList
{
    private Node first;
    private Node last;

    public void addFirstD(Object item)
    {
        if (first == null)
        {
            first = new Node();
            first.setItem(item);
            first.setNext();
            first.setPrevious();
            last = first;
        }
        else
        {
            Node newFirst = new Node();
            newFirst.setItem(item);
            newFirst.setPrevious();
            newFirst.setNext(first);
            first.setPrevious(newFirst);
            first = newFirst;
        }


    }

    public void addLastD(Object item)
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
            newLast.setNext();
            last.setNext(newLast);
            last = newLast;
        }
    }
    public void eraseLast()
    {
        last = last.getPrevious();
        if (last != null)
        {
            last.setNext();
        }
        else
        {
            first = null;
        }
    }
    public void showD()
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

