import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author CanYe
 * @createdate 2019/7/10 18:46
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /*private void add(Node node, E e){
        if(e.equals(node.e))
            return ;

        if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size++ ;
            return ;
        }else if(e.compareTo(node.e) > 0 && node.left == null){
            node.right = new Node(e);
            size++ ;
            return ;
        }

        if(e.compareTo(node.e) < 0 ){
            add(node.left, e);
        }
        else{
            add(node.right, e);
        }

    }*/

    //改进的二分搜索add
    //返回插入新节点后二分搜索树的根节点
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }

        if (root.e.compareTo(e) == 0) {
            return true;
        } else if (root.e.compareTo(e) < 0) {
            return contains(root.left, e);
        } else{
            return contains(root.right, e);
        }
        
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return ;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }


    public void preOrederNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right!=null) {
                stack.push(cur.right);
            }
            if (cur.left!=null) {
                stack.push(cur.left);
            }
        }
    }



    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return ;
        }
        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return ;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);

    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur);

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }
    private Node minimum(Node node){
        if(node.left == null){
            return node ;
        }
        return minimum(node.left);
    }

    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }
    private Node maximum(Node node){
        if(node.right == null){
            return node ;
        }
        return minimum(node.right);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret ;
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
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret ;
    }
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null ;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.left);
        return node;
    }

    public void remove(E e){
        remove(root, e);
    }
    //返回删除节点后树的根节点
    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0 ){
            node.left = remove(node.left, e);
            return node ;
        }else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node ;
        }else{ //e.compareTo(node.e) == 0
            
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null ;
                size --;
                node.right = rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null ;
                size -- ;
                node.left = leftNode ;
            }

            //待删除的节点均不为空
            //找到比删除节点大的最小节点，即待删除右子树的最小节点
            //用这个节点顶替删除的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);//这个位置进行了size--
            successor.left = node.left ;
            node.left = node.right = null ;
            return successor;
        }
    }

}
