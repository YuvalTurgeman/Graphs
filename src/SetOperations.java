public class SetOperations {

    //returns true iff setA is a subset of setB
    public static <T> boolean subset(Set <T> setA, Set<T> setB){
        Iterator<T> iterA = setA.iterator();
        while(iterA.hasNext())
            if(!setB.contains(iterA.next()))
                return false;
        return true;
    }

    //returns true iff setA is a subset of setB
    public static <T> boolean subset2(Set <T> setA, Set<T> setB){
        Iterator<T> iteratorA = setA.iterator();
        while(iteratorA.hasNext())
            if(!setB.contains(iteratorA.next()))
                return false;
        return true;
    }

    //returns the union set of setA and setB
    public static <T> Set<T> union(Set<T> setA, Set<T> setB){
        Set<T> C = new SetAsDynamicArray<>();
        Iterator<T> iterA = setA.iterator();
        Iterator<T> iterB = setB.iterator();
        while(iterA.hasNext())
            C.add(iterA.next());
        while(iterB.hasNext())
            C.add(iterA.next());
        return C;
    }

    //SetAsDynamicArray's "add" function already makes sure that we add it to the set only if it is not
    //already in the set

    //returns the intersection of setA and setB
    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB){
        Set<T> C = new SetAsDynamicArray<>();
        Iterator<T> iterA = setA.iterator();
        while(iterA.hasNext()) {
            T element = iterA.next();
            if (setB.contains(element))
                C.add(element);
        }
        return C;
    }
}
