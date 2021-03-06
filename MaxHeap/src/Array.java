import java.util.Objects;

/**
 * @author CanYe
 * @createdate 2019/7/4 17:39
 */

public class Array<E> {

    private E[] data ;
    private int size ;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity] ;
        size = 0;
    }

    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        size = data.length ;
        for(int i=0 ; i<data.length ; i++){
            data[i] = arr[i] ;
        }
    }
    /**
     * 无参的构造函数
     */
    public Array(){
        this(10);
    }
    /**
     * 数组元素个数
     */
    public int getSize(){
        return size ;
    }
    /**
     * 数组的容量
     */
    public int getCapacity(){
        return data.length ;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0 ;
    }


    //向指定位置添加元素
    public void add(int index , E e){

        if( size == data.length ){
            resize(2 * data.length) ;
        }

        if( index < 0 || index > size ) {
            throw new IllegalArgumentException("AddLast failed. Require index >0 and index < size ");
        }

        for(int i=size-1 ; i>=index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++ ;
    }

    //向元素末尾添加一个新元素
    public void addLast(E e){
        add(size , e ) ;
    }

    public void addFirst(E e){
        add(0 , e);
    }


    public E get(int index){

        if( index < 0 || index >= size ) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index] ;
    }

    public void set(int index , E e){

        if( index < 0 || index >= size ) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
         data[index] = e ;
    }


    public boolean contains(E e){
        for(int i=0 ; i<size ; i++){
            if(e.equals(data[i]) ) {
                return true ;
            }
        }
        return false ;
    }

    public int find(E e){
        for(int i=0 ; i<size ; i++){
            if(e.equals(data[i]) ) {
                return i ;
            }
        }
        return -1 ;
    }




    public E removeFirst(){

        return remove(0) ;

    }

    public E removeLast(){

        return remove(size-1) ;
    }

    public void removeElement(E e){
        int index = find(e) ;
        if( index != -1 ) {
            remove(index) ;
        }
    }

    public E remove(int index){

        if( index < 0 || index >= size ) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }

        E ret = data[index] ;
        for(int i=index+1 ; i<size ; i++){
            data[i-1] = data[i] ;
        }
        size -- ;
        data[size] = null ; //loitering object != memory leak


        if(size == data.length/4 && data.length/2 > 0 ){
            resize(data.length/2) ;
        }

        return ret ;
    }


    @Override
    public String toString(){
         StringBuilder res = new StringBuilder();
         res.append(String.format("Array: size = %d , capacity = %d\n" , size , data.length )) ;
         res.append("[") ;
         for( int i=0 ; i<size ; i++ ) {
             res.append(data[i]);
             if(i != size-1 ){
                 res.append(",");
             }
         }
         res.append("]") ;
         return res.toString();
    }



    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0 ; i<size ; i++){
            newData[i] = data[i] ;
        }
        data = newData ;
    }

    public void swap(int i, int j){
        if(i<0 || i>=size || j<0 || j>=size){
            throw new IllegalArgumentException("Index is illegal.");
        }

        E t = data[i];
        data[i] = data[j];
        data[j] =  t;
    }

}
