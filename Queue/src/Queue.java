/**
 * @author CanYe
 * @createdate 2019/7/5 23:39
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
