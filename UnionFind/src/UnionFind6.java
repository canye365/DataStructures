/**
 * 路径压缩再优化，在find过程中将父节点都指向根节点，压缩到深度最小
 * @author CanYe
 * @createdate 2019/7/9 18:04
 */
public class UnionFind6 implements UF {

    private int[] parent ;
    private int[] rank ; //rank[i]表示以i为根的集合的树的层数

    public UnionFind6(int size){
        parent = new int[size] ;
        rank = new int[size] ;
        for (int i=0 ; i<parent.length ; i++) {
            parent[i] = i ;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //时间复杂度为O(h)，h为树的高度
    public int find(int p){

        if( p<0 || p>=parent.length ){
            throw new IllegalArgumentException("p is out of bound.");
        }
        if(p != parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p] ;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //时间复杂度为O(h)，h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p) ;
        int qRoot = find(q) ;
        if(pRoot ==qRoot) {
            return ;
        }
        if(rank[pRoot] < rank[qRoot] ) {
            parent[pRoot] = qRoot;
        }else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1 ;
        }
    }
}
