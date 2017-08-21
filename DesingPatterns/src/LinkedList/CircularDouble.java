package LinkedList;

public class CircularDouble {
    private NodeDouble first ;
    private NodeDouble last;
    public void addLast(Object item)
    {
        if (first == null)
        {
            last = new NodeDouble();
            last.setItem(item);
            last.setNext(last);
            last.setPrevious(last);
            first = last;
        }
        else
        {
            NodeDouble newLast = new NodeDouble();
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
        NodeDouble temp = new NodeDouble();
        temp = last.getPrevious().getPrevious();
        last = last.getPrevious();
        last.setPrevious(temp);
        last.setNext(first);

    }
    public void show()
    {
        NodeDouble temp = first;

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
