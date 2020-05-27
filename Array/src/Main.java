public class Main {

    public static void main(String[] args) {
	    // write your code here
        Array arr = new Array(20) ;
        for(int i=0 ; i<19 ; i++){
            arr.addLast(i);
        }

        arr.add(1,100);
        System.out.println(arr.toString());
        arr.add(1,101);
        System.out.println(arr.toString());
        arr.removeLast();
        System.out.println(arr.toString());
    }
}
