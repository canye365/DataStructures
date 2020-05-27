import javax.swing.text.Segment;

public class Main {

    public static void main(String[] args) {

        Integer[] data = {1,2,3,4,5,6,7,8,9} ;

        /*SegmentTree<Integer> segmentTree = new SegmentTree<>(data , new Merge<Integer>(){
            @Override
            public Integer merge(Integer a , Integer b){
                return a+b ;
            }
        });*/
        SegmentTree<Integer> segmentTree = new SegmentTree<>(data, (a,b) -> a + b );

        System.out.println(segmentTree.toString());
        System.out.println(segmentTree.query(0,4));

    }
}
