### 호환하기

---

→ 서로 다른 인터페이스를 연결함

→ 클라이언트가 사용하던 방식대로 조정헤주는 객체

→  안드로이드에서 View를 위한 Adapter들..

```java
public interface Print {
	public abstract void printWeak();
	public abstract void printStrong();
}
```

```java
public class Banner {
	private String string;
	public Banner(String string) {
		this.string = string;
	}
	public void showWithParen() {
		System.out.println("(" + string + ")");
	}
	public void showWithAster() {
		System.out.println("*" + string + "*");
	}
}
```

```java
public class Main {
	public static void main(String[] args) {
		Print p = new PrintBanner("Hello");
		p.printWeak();
		p.printStrong();
	}
}
```

→ `PrintBanner`를 상속과 합성의 방법으로 구현해보세요