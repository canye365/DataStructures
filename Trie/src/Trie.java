import java.util.Set;
import java.util.TreeMap;

/**
 * @author CanYe
 * @createdate 2019/7/9 14:17
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord ){
            this.isWord = isWord ;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root ;
    private int size ;

    public Trie(){
        root = new Node();
        size = 0 ;
    }

    public int getSize(){
        return size ;
    }

    public void add(String word) {
        Node cur = root ;
        for(int i=0 ; i<word.length() ; i ++){
            char c = word.charAt(i) ;
            if(cur.next.get(c) == null ){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c) ;
        }
        if(!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word){
        
        Node cur = root ;
        for(int i=0 ; i<word.length() ; i++){
            char c = word.charAt(i) ;
            if(cur.next.get(c) == null ){
                return false ;
            }
            cur = cur.next.get(c) ;
        }
        return cur.isWord ;
    }

    //查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        
        Node cur = root ;
        for(int i=0 ; i<prefix.length() ; i++){
            char c = prefix.charAt(i) ;
            if(cur.next.get(c) == null ) {
                return false;
            }
            cur = cur.next.get(c) ;
        }
        return true ;
    }

    public boolean search2(String word){
        return match(root, word, 0);
    }

    private boolean match(Node root, String word, int index) {

        if(index == word.length()) {
            return root.isWord;
        }

        char c = word.charAt(index);
        if(c != '.'){
            if(root.next.get(c) == null ){
                return false;
            }
            return match(root.next.get(c), word, index+1);
        }else{
            for(Character nextChar : root.next.keySet())  {
                if(match(root.next.get(nextChar), word, index+1)){
                    return true ;
                }
            }
            return false ;
        }

    }
}
