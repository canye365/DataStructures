import java.util.*;
import java.util.PriorityQueue;

public class Main {

        public List<Integer> topKFrequent(int[] nums, int k) {

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (Integer num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (a, b) -> (map.get(a) - map.get(b))
                    //Comparator.comparingInt(map::get)
            );
            for (Integer key : map.keySet()) {
                if(pq.size() < k){
                    pq.add(key);
                }else if(map.get(key) > map.get(pq.peek()) ){
                    pq.remove();
                    pq.add(key);
                }
            }

            List<Integer> list = new LinkedList<>();
            while(!pq.isEmpty()){
                list.add(pq.remove());
            }
            return list;
        }

        public static void main(String[] args) {

            
        }
}
