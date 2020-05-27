/**
 * @author CanYe
 * @createdate 2019/7/6 12:35
 */
public class SegmentTree<E> {

    private E[] tree ;
    private E[] data ;
    private Merge<E> merge ;

    public SegmentTree(E[] arr ,Merge<E> merge){

        this.merge = merge ;

        data = (E[])new Object[arr.length] ;
        for(int i=0 ; i<arr.length; i++){
             data[i] = arr[i]  ;
        }
        
        tree = (E[])new Object[arr.length * 4] ;

        buildSegmentTree(0 , 0 , data.length-1 ) ;
    }
    //构建线段树，第一个参数为树的根节点索引，范围为[l...r]
    private void buildSegmentTree(int treeIndex , int l , int r){
        //递归写法，先考虑递归的终止条件
        if( l == r ){
            tree[treeIndex] = data[l] ;
            return ;
        }

        int leftTreeIndex = leftChild(treeIndex) ;
        int rightTreeIndex = rightChild(treeIndex) ;
        int mid = l + (r-l) / 2 ;

        buildSegmentTree(leftTreeIndex , l , mid );
        buildSegmentTree(rightTreeIndex , mid+1 , r );

        tree[treeIndex] = merge.merge( tree[leftTreeIndex] , tree[rightTreeIndex] ) ;
    }

    public E get(int index){
        if(index <0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal.") ;
        }
        return data[index] ;
    }
    public int getSize(){
        return data.length ;
    }

    //获取左孩子的索引
    private int leftChild(int index){
        return index*2+1 ;
    }
    //获取右孩子的索引
    private int rightChild(int index){
        return index*2+2 ;
    }

    //搜索区间[queryL , queryR]的值
    public E query(int queryL , int queryR){

        if( queryL < 0 || queryL >= tree.length || queryR < 0 || queryR >= tree.length || queryL > queryR ){
            throw new IllegalArgumentException("Index is illegal.");
        }
        
        return query(0, 0, data.length-1, queryL, queryR) ;
    }

    public void update(int index, E val){
        if(index <0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        update(0, 0, data.length-1, index, val);
    }
    //在以treeIndex为根的线段树中[l..r]范围内找到索引index
    private void update(int treeIndex, int l, int r, int index, E val){
        //仍然是递归实现，设置结束的临界条件
        if( l == r){
            tree[treeIndex] = val ;
            return ;
        }
        int leftTreeTree = leftChild(treeIndex) ;
        int rightTreeTree = rightChild(treeIndex) ;
        int mid = l + (r-l)/2 ;

        if( index >= mid+1 ){
            update(rightTreeTree, mid+1, r, index, val);
        }else{
            update(leftTreeTree, l, mid, index, val);
        }

        //这里要更改更新后的叶子结点上面的那些结点
        tree[treeIndex] = merge.merge(tree[leftTreeTree], tree[rightTreeTree]);

    }


    //查询以treeIndex为根的线段树中[l..r]范里，搜索区间[queryL , queryR]的值
    private E query(int treeIndex , int l, int r, int queryL , int queryR){
        //同样递归判断终止条件
        if(queryL == l && queryR == r ){
            return tree[treeIndex] ;
        }

        int leftTreeIndex = leftChild(treeIndex) ;
        int rightTreeIndex = rightChild(treeIndex) ;
        int mid = l + (r-l)/2 ;
        if(queryL >= mid+1 ){                         
            return query(rightTreeIndex, mid+1, r, queryL, queryR);
        }else if(queryR <= mid ){
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid+1, r, mid+1, queryR);

        return merge.merge(leftResult, rightResult) ;
    }



    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("SegmentTree: ");
        res.append("[") ;
        for(int i=0 ; i<tree.length ; i++){

            if(tree[i] != null ){
                res.append(tree[i]);
            }else{
                res.append("null");
            }
            if(i+1 != tree.length){
                res.append(",") ;
            }
        }

        res.append("]") ;

        return res.toString() ;
    }

}
