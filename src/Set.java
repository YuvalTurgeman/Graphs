public interface Set<T> extends Iterable<T> {
    //returns the amount of elements in the set
    public int size();
    //returns true if it adds the element to the set (only if the element is not already in the set)
    //if the element is already in the set, returns false
    public void add(T element);
    //returns true if the set contains a given element
    public boolean contains(T element);
    //removes the given element from the set
    public void remove(T element);
    //return true if the set is empty
    public boolean isEmpty();
}
