import org.junit.Before;
import org.junit.Test;

/**
 * @author CanYe
 */

public class DulLinkedListTest {

    @Test
    public void test(){
        DulLinkedList<Integer> linkedList = new DulLinkedList<>();
        linkedList.addLast(4);
        linkedList.addFirst(2);
        linkedList.addLast(5);
        linkedList.addFirst(0);
        assert linkedList.printLinkedList().equals("[0, 2, 4, 5]");
        assert linkedList.getSize() == 4;
        linkedList.add(1, 1);
        linkedList.add(5, 6);
        linkedList.add(3, 3);
        assert linkedList.printLinkedList().equals("[0, 1, 2, 3, 4, 5, 6]");
        assert linkedList.getSize() == 7;
        Integer a = linkedList.get(4);
        linkedList.removeByIndex(3);
        linkedList.removeElement(a);
        Integer b = linkedList.removeElement(5);
        assert b == 5;
        Integer c = linkedList.removeElement(100);
        assert c == null;
        linkedList.removeFirst();
        linkedList.removeLast();
        assert linkedList.printLinkedList().equals("[1, 2]");
        assert linkedList.getSize() == 2;
    }

}
