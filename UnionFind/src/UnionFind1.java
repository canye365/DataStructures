/**
 * @author CanYe
 * @createdate 2019/7/9 16:50
 */
public class UnionFind1 implements UF{

    public int[] id ;

    public UnionFind1(int size){
        id = new int[size];

        for(int i=0 ; i<size ; i++){
            id[i] = i ;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    public int find(int p){
        if( p<0 || p>=id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p] ;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID){
            return ;
        }
        for(int i=0 ; i<id.length ; i++){
            if(id[i] == pID) {
                id[i] = qID ;
            }
        }
    }
}
