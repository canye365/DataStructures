import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author CanYe
 * @createdate 2019/7/15 20:21
 * 347. Top K Frequent Elements
 */
class Solution {

    private class Freq implements Comparable<Freq> {
        int e, freq;

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if(pq.getSize() < k){
                pq.enqueue(new Freq(key, map.get(key)));
            }else if(map.get(key) > pq.getFront().freq ){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        List<Integer> list = new LinkedList<>();
        while(!pq.isEmpty()){
            list.add(pq.dequeue().e);
        }

        return list;
    }
}