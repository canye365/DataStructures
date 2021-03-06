/**
 * @author CanYe
 * @createdate 2019/7/6 0:25
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    //在链表某个位置添加节点 ,位置从0开始
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*Node node = new Node(e);
        node.next = prev.next ;
        prev.next = node ;*/

        prev.next = new Node(e, prev.next);

        size++;
    }

    //在链表头添加节点
    public void addFirst(E e) {
        /*Node node = new Node(e);
        node.next = head ;
        head = node ;*/
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node retNode = dummyHead.next ;
        for(int i=0 ; i<index ; i++){
            retNode = retNode.next;
        }
        return retNode.e;
    }

    public E getFirst(){
        return get(0); 
    }
    public E getLast(){
        return get(size-1);
    }

    public E remove(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node pre = dummyHead ;
        for(int i=0 ; i<index ; i++){
            pre = pre.next ;
        }
        Node retNode = pre.next ;
        pre.next = retNode.next ;
        retNode.next = null ;
        size -- ;
        return retNode.e ;
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }

}
