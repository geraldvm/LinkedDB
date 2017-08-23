package LinkedList;

public class Simple {
    private Node first;
    private Node last;


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


    public void erase(Object item)
    {
        Node temp;
        temp=this.first;
        if (temp.getItem()==item)
        {
            this.first=temp.getNext();
        }

        else
        {
            while (temp.getNext()!=null)
            {
                if (temp.getNext().getItem()==item)
                {
                    if(temp.getNext()==last)
                    {
                        temp.setNext(null);
                        last=temp;
                    }
                    else
                    {
                        temp.setNext(temp.getNext().getNext());
                    }



                }
                else if (temp.getNext()!=null)
                {
                    temp=temp.getNext();
                }
            }

        }

    }

    public void update(Object item, Object newValue)
    {
        Node temp = first;
        if (last.getItem()==item)
        {
            last.setItem(newValue);
        }
        while (temp.getNext()!=null)
        {
            if (temp.getItem()==item)
            {
                temp.setItem(newValue);
            }
            temp=temp.getNext();
        }

    }

}
