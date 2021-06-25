public class SetAsDynamicArray<T> implements Set<T> {

    //fields
    private List<T> elements;

    //constructors
    public SetAsDynamicArray(){
        elements = new DynamicArray<T>();
    }

    //methods
    public int size() {
        return elements.size();
    }

    public void add(T element) {
        if(!elements.contains(element))
            elements.add(element);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void remove(T element) {
        elements.remove(element);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
