import java.util.ArrayList;
import java.util.Random;

/**
 * 比较有序序列
 */
public class Main3 {

    public static void main(String[] args) {
        int n = 10000000;

        Random random = new Random();
        ArrayList<Integer>  testData = new ArrayList<>();
        for(int i=0 ; i <n ; i++){
            testData.add(i);
        }

        //Test AVLTree
        long startTime = System.nanoTime();
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        for(Integer data : testData){
            avlTree.add(data,null);
        }

        long endTime = System.nanoTime();
        double time = (endTime-startTime)/1000000000.0 ;
        System.out.println("AVLTree: " + time + " s");

        System.out.println();

        
        //Test RBTree
        startTime = System.nanoTime();
        RBTree<Integer,Integer> rbt = new RBTree<>();
        for(Integer data : testData){
            rbt.add(data,null);
        }
        endTime = System.nanoTime();
        time = (endTime-startTime)/1000000000.0 ;
        System.out.println("RBTree: " + time + " s");

    }
}
