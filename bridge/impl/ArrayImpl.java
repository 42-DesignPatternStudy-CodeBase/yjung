package bridge.impl;
import java.util.ArrayList;

public class ArrayImpl<T> implements AbstractList<T> {
    ArrayList<T> data = new ArrayList<T>();

    @Override
    public void addElement(T obj) {
        data.add(obj);
    }
    @Override
    public T deleteElement(int i) {
        T t = data.get(i);
        data.remove(i);
        return t;
    }
    @Override
    public int insertElement(T obj, int i) {
        data.add(i, obj);
        return i;
    }
    @Override
    public T getElement(int i) { return data.get(i); }
    @Override
    public int getElementSize() { return data.size(); }
}
