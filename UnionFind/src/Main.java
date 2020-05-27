import java.util.Random;

/**
 * @author CanYe
 * @createdate 2019/7/9 17:31
 */
public class Main {

    public static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();

        for(int i=0 ; i<m ; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
            if( !uf.isConnected(a,b)) {
               throw new RuntimeException("The UF is not connected by a and b");
            }
        }

        for(int i=0 ; i>m ; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b) ;
        }

        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int size = 4000*10000;
        int m = 4000*10000 ;
        System.out.println("the size : "+size+ "and the m : "+m);

        /*UnionFind1 uf1 = new UnionFind1(size);
        double time = testUF(uf1, m);
        System.out.println("the uf1's time is : "+time+ " s");

        UnionFind2 uf2 = new UnionFind2(size);
        time = testUF(uf2, m);
        System.out.println("the uf2's time is : "+time+ " s");*/

        UnionFind3 uf3 = new UnionFind3(size);
        double time = testUF(uf3, m);
        System.out.println("the uf3's time is : "+time+ " s");

        UnionFind4 uf4 = new UnionFind4(size);
        time = testUF(uf4, m);
        System.out.println("the uf4's time is : "+time+ " s");
        
        UnionFind5 uf5 = new UnionFind5(size);
        time = testUF(uf5, m);
        System.out.println("the uf5's time is : "+time+ " s");

        UnionFind6 uf6 = new UnionFind6(size);
        time = testUF(uf6, m);
        System.out.println("the uf6's time is : "+time+ " s");
    }
}
