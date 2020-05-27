/**
 * 基于sz的优化
 * @author CanYe
 * @createdate 2019/7/9 17:23
 */
public class UnionFind3 implements UF {

    private int[] parent ;
    private int[] sz ; //sz[i]表示以i为根的集合中元素的个数

    public UnionFind3(int size){
        parent = new int[size] ;
        sz = new int[size] ;
        for (int i=0 ; i<parent.length ; i++) {
            parent[i] = i ;
            sz[i] = 1;
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

        while(p != parent[p]) {
            p = parent[p] ;                        
        }
        return p ;
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
        if(sz[pRoot] < sz[qRoot] ) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
