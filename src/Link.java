public class Link<T> {

    //fields
    private T data;
    private Link next;

    //constructors
    public Link(T data, Link <T> next){
        this.data = data;
        this.next = next;
    }

    public T getData(){
        return data;
    }

    public Link<T> getNext(){
        return next;
    }

    public T setData(T data){
        T tmp = data;
        this.data = data;
        return tmp;
    }

    public void setNext(Link <T> next){
        this.next = next;
    }
}
