public interface List <T> extends Iterable<T> {

    //returns true if the list is empty.
    public boolean isEmpty();

    //returns the amount of elements in the list.
    public int size();

    //returns true if the list contains a specific element.
    public boolean contains(T element);

    //returns the element in a specific index.
    public T get(int index);

    //replaces the element in a specific index and returns the value of the element prior to the replacement.
    public T set(T element, int index);

    //adds an element to the list.
    public void add(T element);

    //adds an element to the list in a specific index.
    public void add(T element, int index);

    //removes the first occurrence of the element in the list.
    public void remove(T element);

    //removes and returns the element in a given index.
    public T remove (int index);
}
