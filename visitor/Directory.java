package visitor;
import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> dir = new ArrayList<Entry>(); // 디렉토리의 이름
    public Directory(String name) { // 생성자
        this.name = name;
    }
    @Override
    public String getName() { // 이름을 얻는다.
        return name;
    }
    @Override
    public int getSize() { // 사이즈를 얻는다.
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    @Override
    public Entry add(Entry entry) { // 엔트리의 추가
        dir.add(entry);
        return this;
    }
    @Override
    public Iterator iterator() { // Iterator의 생성
        return dir.iterator();
    }
    @Override
    public void accept(Visitor v) { // 방문자를 받아들임
        v.visit(this);
    }
}
