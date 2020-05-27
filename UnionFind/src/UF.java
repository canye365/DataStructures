/**
 * @author CanYe
 * @createdate 2019/7/9 16:50
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
