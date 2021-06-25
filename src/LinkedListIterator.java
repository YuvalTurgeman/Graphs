import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {

    //fields
    private Link<T> curr;

    //constructor
    public LinkedListIterator(Link<T> first){
        curr =first;
    }

    //methods
    public boolean hasNext(){
        return curr != null;
    }

    public T next(){
        if(!hasNext())
            throw new NoSuchElementException();
        T next = curr.getData();
        curr = curr.getNext();
        return next;
    }
}
