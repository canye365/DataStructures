/**
 * 双向链表
 * @author CanYe
 */
public class DulLinkedList<E> {

    private class Node {
        public E e;
        public Node pre;
        public Node next;

        public Node(E e, Node pre, Node next) {
            this.e = e;
            this.pre = pre;
            this.next = next;
        }
        public Node(E e) {
            this.e = e;
        }
        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private Node dummyTail;
    private int size;

    public DulLinkedList(){
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        this.size = 0;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node ins = new Node(e);
        Node temp = dummyHead.next;

        while(index -- > 0) temp = temp.next;
        ins.next = temp;
        ins.pre = temp.pre;
        temp.pre.next = ins;
        ins.next.pre = ins;
        size ++;
    }

    public void addFirst(E e){
        add(0, e);
    }
    public void addLast(E e){
        add(size, e);
    }

    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node temp = dummyHead.next;
        while(index -- > 0) temp = temp.next;
        return temp.e;
    }


    public E removeElement(E e){

        Node temp = dummyHead.next;
        while(temp != dummyTail){
            if(temp.e.equals(e))
                break;
            temp = temp.next;
        }

        if(temp != dummyTail){
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
            size --;
            return temp.e;
        }
        return null;
    }

    public E removeByIndex(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node temp = dummyHead.next;
        while(index -- > 0) temp = temp.next;
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
        size --;
        return temp.e;
    }

    public E removeFirst(){
        return removeByIndex(0);
    }
    public E removeLast(){
        return removeByIndex(size-1);
    }

    public String printLinkedList(){
        Node temp = dummyHead.next;
        StringBuffer strbuf = new StringBuffer("");
        strbuf.append("[");
        while(temp != dummyTail){
            if(temp == dummyTail.pre)
                strbuf.append(temp.e);
            else
                strbuf.append(temp.e).append(", ");
            temp = temp.next;
        }
        strbuf.append("]");
        return strbuf.toString();
    }

}
