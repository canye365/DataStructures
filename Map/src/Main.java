import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    private static double testMap(Map<String, Integer> map, String filename){
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
                                     
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: "+words.size());

            for(String word : words){
                if(map.contains(word)){
                    map.set(word,map.get(word)+1);
                }else{
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: "+ map.getSize());
            System.out.println("Frequency of PRIDE: "+ map.get("pride"));
            System.out.println("Frequency of PREJUDICE: "+ map.get("prejudice"));
        }
        
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";


        BSTMap<String, Integer> map2 = new BSTMap<>();
        double time2 = testMap(map2, filename);
        System.out.println("LinkedListMap: "+ time2 + " s");

        System.out.println();

        LinkedLisrtMap<String, Integer> map1 = new LinkedLisrtMap<>();
        double time1 = testMap(map1, filename);
        System.out.println("LinkedListMap: "+ time1 + " s");

        System.out.println();

        AVLMap<String, Integer> map3 = new AVLMap<>();
        double time3 = testMap(map3, filename);
        System.out.println("AVLMap: "+ time3 + " s");
        
    }

}
