package visitor;
import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String dir = ""; // 현재 주목하고 있는 디렉토리명
    @Override
    public void visit(File file) { // 파일을 방문했을 때 호출된다.
        System.out.println(dir + "/" + file);
    }
    @Override
    public void visit(Directory directory) { // 디렉토리를 방문했을 때 호출된다.
        System.out.println(dir + "/" + directory);
        String savedir = dir;
        dir = dir + "/" + directory.getName();
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        dir = savedir;
    }
}
