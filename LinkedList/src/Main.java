public class Main {

    public static void main(String[] args) {
	// write your code here

        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i=0 ; i<10 ; i++){
            linkedList.addLast(i);
        }

        linkedList.add(2,666);
        System.out.println(linkedList);
        linkedList.remove(0);
        System.out.println(linkedList);
        System.out.println(linkedList.get(2));
    }
}
