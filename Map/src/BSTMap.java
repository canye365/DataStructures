import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author CanYe
 * @createdate 2019/7/15 14:14
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key, V value){
            this.key = key;
            this.value = value ;
            this.left = this.right = null ;
        }

        @Override
        public String toString(){
            return key.toString() + ":" + value.toString();
        }
    }

    private Node root ;
    private int size ;

    public BSTMap(){
        root = null ;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }
    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else{
            node.value = value ;
        }

        return node;
    }

    private Node getNode(Node node, K key){
        if(node == null){
            return null ;
        }
        if(key.compareTo(node.key) > 0){
            return getNode(node.right, key);
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }

        return node ;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key+" doesn't exist!");
        }
        node.value = newValue;
    }

    @Override
    public V remove(K key) {

        Node node = getNode(root, key);
        if(node == null)
            return null ;
        else{
            root = remove(root, key);
            return node.value;
        }
    }

    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null ;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node ;
        }
        return minimum(node.left);
    }

    //返回删除节点后树的根节点
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { //e.compareTo(node.e) == 0

            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                node.right = rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                node.left = leftNode;
            }

            //待删除的节点均不为空
            //找到比删除节点大的最小节点，即待删除右子树的最小节点
            //用这个节点顶替删除的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);//这个位置进行了size--
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();

        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: "+words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
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

    }

}
