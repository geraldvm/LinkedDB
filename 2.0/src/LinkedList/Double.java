package LinkedList;

public class Double {
    private NodeDouble first;
    private NodeDouble last;

    public void addFirst(Object item)
    {
        if (first == null)
        {
            first = new NodeDouble();
            first.setItem(item);
            last = first;
        }
        else
        {
            NodeDouble newFirst = new NodeDouble();
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
            NodeDouble newLast = new NodeDouble();
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
    public void showD()
    {
        NodeDouble temp = first;
        while (temp != null)
        {
            System.out.println(temp.getItem());
            temp = temp.getNext();
        }
    }
    public void showReverse()
    {
        NodeDouble temp = last;
        while (temp != null)
        {
            System.out.println(temp.getItem());
            temp = temp.getPrevious();
        }
    }

    public Boolean search(Object item)
    {
        NodeDouble temp = first;
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
