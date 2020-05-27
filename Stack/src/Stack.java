/**
 * @author CanYe
 * @createdate 2019/7/5 22:48
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
    
}
