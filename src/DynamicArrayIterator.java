import java.util.NoSuchElementException;

public class DynamicArrayIterator<T> implements Iterator<T> {

    //fields
    private DynamicArray<T> array;
    private int index;

    //constructor
    public DynamicArrayIterator(DynamicArray<T> array){
        this.array = array;
        index = 0;
    }

    //methods
    public boolean hasNext(){
        return index<array.size();
    }

    public T next(){
        if(!hasNext())
            throw new NoSuchElementException();
        T next = array.get(index);
        index++;
        return next;
    }

}
