package Background.LinkedList.SimpleList;

import Background.Documents.Attribute;
import sun.net.www.content.text.Generic;

public class SimpleList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size=0;

    public SimpleList(){
        this.size=0;
    }

    public int length() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.first==null;
    }



    public void show()
    {
        Node<T> temp = first;
        while (temp != null)
        {
            System.out.println(temp.getItem());
            temp = temp.getNext();
        }
    }

    public void addLast(T item)
    {

        Node<T> newLast = new Node<>();
        newLast.setItem(item);

        if (this.isEmpty())
        {
            last = newLast;
            first = newLast;
            ++this.size;
        }

        else
        {
            last.setNext(newLast);
            last = newLast;
            ++this.size;

        }
    }

    public void erase(Object item)
    {
        Node<T> temp;
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

    public void update(T item, T newValue)
    {
        Node<T> temp = first;
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

    public void search(T value)
    {
        search(value, this.first);
    }

    private void search(T value, Node<T> temp)
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

    public Node<T> find(int pos)
    {
        return find_aux(pos);
    }

    private Node<T> find_aux(int pos)
    {
        Node<T> temp = this.first;
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