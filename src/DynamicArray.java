import java.util.Arrays;

public class DynamicArray <T> implements List <T> {

    //fields
    private static int DEFAULT_CAPACITY = 3;
    private Object[] data;
    private int size;
    private int incrementSize;

    //constructors
    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("Capacity is not positive");

        data = new Object[initialCapacity];
        size = 0;
        incrementSize = initialCapacity;
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    //methods
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(element))
                return true;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    public void add(T element) {
        if (element == null)
            throw new IllegalArgumentException();
        data[size] = element;
        size++;
        ensureCapacity();
    }

    public void add(T element, int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        if (element == null)
            throw new IllegalArgumentException();
        if (index == size())
            add(element);
        else
            data[index] = element;
    }

    public boolean equals(Object other) {
        if (!(other instanceof DynamicArray<?>))
            return false;
        if (size() != ((DynamicArray<?>) other).size())
            return false;
        for (int i = 0; i < size(); i++)
            if (!get(i).equals(((DynamicArray<?>) other).get(i)))
                return false;
        return true;
    }

    public String toString() {
        return Arrays.toString(data);
    }

    public T set(T element, int index) {
        if (element == null)
            throw new IllegalArgumentException();
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        T tmp = get(index);
        data[index] = element;
        return tmp;
    }

    public void remove(T element) {
        if (element == null)
            throw new IllegalArgumentException();
        boolean removed = false;
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(element))
                removed = true;
            if (removed)
                data[i] = data[i + 1];
        }
        data[size() - 1] = null;
        size--;
        return;
    }

    public T remove(int index){
        if(index >= size() || index<0) {
            throw new IndexOutOfBoundsException();
        }
        T tmp = (T)data[index];
        for(int i = index; i<size();i++)
            data[i] = data[i+1];
        data[size()-1] = null;
        size--;
        return tmp;
    }



    private void ensureCapacity(){
        if(size >= data.length) {
            Object[] newData = new Object[data.length + incrementSize];
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
            data = newData;
        }
    }

    public Iterator<T> iterator(){
        return new DynamicArrayIterator<T>(this);
    }

}
