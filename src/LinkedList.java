import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

    //fields
    private Link<T> first;
    private int size;

    //constructors
    public LinkedList(){
        first = null;
        size = 0;
    }

    //methods
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int size = 0;
        Link<T> runner = first;
        while(runner!=null) {
            size++;
            runner = runner.getNext();
        }
        return size;
    }

    public boolean contains(T element) {
        Link <T> runner = first;
        while(runner!=null) {
            if (runner.getData().equals(element))
                return true;
        }
        return false;
    }

    public T get(int index) {
        if(index < 0 || index>=size)
            throw new IndexOutOfBoundsException();
        Link <T> runner = first;
        for(int i=0;i<index;i++)
            runner = runner.getNext();
        return runner.getData();
    }

    public T set(T element, int index) {
        if(element == null)
            throw new IllegalArgumentException();
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Link <T> runner = first;
        for(int i=0; i<index; i++)
            runner = runner. getNext();
        return runner.setData(element);
    }

    public void add(T element) {
       if(element == null)
           throw new IllegalArgumentException();
        Link <T> runner = first;
       while(runner.getNext()!=null)
           runner = runner.getNext();
       Link <T> toAdd = new Link<T>(element, null);
       runner.setNext(toAdd);
       size = size+1;
    }

    public void add(T element, int index) {
        if(element == null)
            throw new IllegalArgumentException();
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(isEmpty())
            throw new NoSuchElementException();
        Link <T> runner = first;
        for(int i=0; i<index-1; i++)
            runner = runner. getNext();
        Link <T> toAdd = new Link<T>(element,runner.getNext());
        runner.setNext(toAdd);
        size = size + 1;
    }

    public void remove(T element) {
        if(element == null)
            throw new IllegalArgumentException();
        Link <T> runner = first, prev = first;
        while(runner!=null) {
            if (runner.getData().equals(element)) {
                if (first.equals(runner))
                    first = first.getNext();
                else
                    prev.setNext(runner.getNext());
            } else {
                prev = runner;
                runner = runner.getNext();
            }
        }
    }

    public T remove(int index) {
        if(index < 0 || index >=size)
            throw new IndexOutOfBoundsException();
        Link <T> runner = first;
        for(int i=0;i < index-1;i++)
            runner = runner.getNext();
        T tmp = runner.getNext().getData();
        runner.setNext(runner.getNext().getNext());
        return tmp;
    }

    public String toString() {
        String output = "[";
        Link<T> runner = first;
        while (runner != null) {
            output = output + runner.getData().toString();
            runner = runner.getNext();
            if (runner == null)
                output = output + ", ";
        }
        output = output + "]";
        return output;
        }

    public boolean equals(Object other) {
        if (!(other instanceof LinkedList<?>) || this.size != ((LinkedList<T>) other).size)
            return false;
        Link<T> runner1 = first;
        Link<T> runner2 = ((LinkedList<T>) other).first;
        while (runner1 != null) {
            if (!runner1.equals(runner2))
                return false;
            runner1 = runner1.getNext();
            runner2 = runner2.getNext();
        }
        return true;
    }

    public Iterator<T> iterator(){
        return new LinkedListIterator<T>(first);
    }

}
