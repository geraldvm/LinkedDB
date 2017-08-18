package LinkedList;



public class LinkedListS {
    private Node first;
    private Node last;


    public void addFirst(Object item) {
        Node newFirst = new Node();
        newFirst.setItem(item);
        if (first == null)
        {
            first = newFirst;
        }
        else
        {
            newFirst.setNext(first);
            /*
            last.setItem(first.getItem());

            last.setNext(null);
            */
            first = newFirst;
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

    public void addLast(Object item)
    {

        Node newLast = new Node();
        newLast.setItem(item);
        newLast.setNext();


        if (first==null)
        {
            last = newLast;
            first = newLast;
        }

        else if (last==null)
        {
            last = newLast;
        }
        else
        {
                last.setNext(newLast);
                last = newLast;
        }
    }


    public void search(Object value)
    {
        search(value, this.first);
    }

    private void search(Object value, Node temp)
    {

        if(temp.getItem()==value)
        {

            search(temp.getItem()==value);
        }
        else if (temp.getNext()==null)
        {
            search(temp.getItem()==value);
        }
        else
        {
            search(value, temp.getNext());
        }
    }

    private boolean search(boolean x)
    {
        System.out.println(x);
        return x;
    }


}
