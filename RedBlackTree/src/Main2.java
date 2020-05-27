import java.util.ArrayList;
import java.util.Random;

/**
 * 比较随机序列
 */
public class Main2 {

    public static void main(String[] args) {
        int n = 5000000;

        Random random = new Random();
        ArrayList<Integer>  testData = new ArrayList<>();
        for(int i=0 ; i <n ; i++){
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        //Test BST
        long startTime = System.nanoTime();
        BST<Integer,Integer> bst = new BST<>();
        for(Integer data : testData){
            bst.add(data,null);
        }

        long endTime = System.nanoTime();
        double time = (endTime-startTime)/1000000000.0 ;
        System.out.println("BST: " + time + " s");

        System.out.println();

        //Test AVLTree
        startTime = System.nanoTime();
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        for(Integer data : testData){
            avlTree.add(data,null);
        }

        endTime = System.nanoTime();
        time = (endTime-startTime)/1000000000.0 ;
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
