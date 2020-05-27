/**
 * 将数组改为树
 * @author CanYe
 * @createdate 2019/7/9 17:03
 */
public class UnionFind2 implements UF {

    private int[] parent ;

    public UnionFind2(int size){
        parent = new int[size] ;
        for (int i=0 ; i<parent.length ; i++) {
            parent[i] = i ;      
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
        parent[pRoot] = qRoot;
    }
}
