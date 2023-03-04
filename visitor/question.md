### 객체를 방문하여 기능을  처리함

---

→  클래스에 다양한 기능이 추가되거나 삭제되는 일이 자주 일어나면 클래스를 자주 변경해야 하는 번거로움이 있다

→ 객체가 가지는 기능들을 클래스로 분리한다

→ 기능을 구현한 클래스를 Visitor라고 하고 각 객체는 이 Visitor를 accept 함으로써 기능이 수행된다

→ 모든 기능을 적용하기 위한 기능을 추가할 때는 각 클래스를 수정하지 않고 Visitor를 추가하면 되지만, 클래스의 캡슐화에 위배되는 구현 방식이므로 클래스의 캡슐화가 크게 중요하지 않는 경우에 적용해야 하는 패턴임

→ 따라서 클래스 구조의 변화는 거의 없고 기능의 추가 삭제가 자주 발생할 때 사용하는 것이 좋음

→ 복합 객체인 경우 단일 객체외 동일한 기능이 구현될 때 이를 Vistitor로 분리하고 Visitor가 각 객체를 순회하는 방식으로 사용할 수 있음

```java
// Visitor.java
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
```

```java
// Acceptor.java
public interface Acceptor {
    public abstract void accept(Visitor v);
}
```

```java
// Entry.java
public abstract class Entry implements Acceptor {
	public abstract String getName(); // 이름을 얻는다.
	public abstract int getSize(); // 사이즈를 얻는다.
	public Entry add(Entry entry) throws FileTreatmentException {
	// 엔트리를 추가
		throw new FileTreatmentException();
	}
	public Iterator iterator() throws FileTreatmentException {
	// Iterator의 생성
		throw new FileTreatmentException();
	}
	public String toString() { // 문자열 표현
		return getName() + " (" + getSize() + ")";
	}
}
```

```java
public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("Making root entries...");
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("bin");
			Directory tmpdir = new Directory("tmp");
			Directory usrdir = new Directory("usr");
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			bindir.add(new File("vi", 10000));
			bindir.add(new File("latex", 20000));
			rootdir.accept(new ListVisitor());
			System.out.println("");
			System.out.println("Making user entries...");
			Directory Kim = new Directory("Kim");
			Directory Lee = new Directory("Lee");
			Directory Kang = new Directory("Kang");
			usrdir.add(Kim);
			usrdir.add(Lee);
			usrdir.add(Kang);
			Kim.add(new File("diary.html", 100));
			Kim.add(new File("Composite.java", 200));
			Lee.add(new File("memo.tex", 300));
			Kang.add(new File("game.doc", 400));
			Kang.add(new File("junk.mail", 500));
			rootdir.accept(new ListVisitor());
		}
		catch (FileTreatmentException e) {
			e.printStackTrace();
		} 
	}
}
```

→ `Entry`를 상속받은 File과 `Directory`를 구현하고, `ListVisitor`를 만들어서 `main()`을 수행하세요