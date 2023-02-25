### 기능의 확장과 구현의 확장을 분리

→ 기능(추상적인 개념)의 확장과 구현의 확장을 분리한다

→ 하나의 기능에 대한 다양한 구현이 적용될 수 있음 - 구현부에 대한 참조를 가진다

→ 기능과 구현의 확장이 혼재하면 상속관계가 복잡해 짐

→ 실행 중에 구현을 선택할 수도 있고, 사용하는 코드(클라이언트)에서는 가능 인터페이스를 사용하므로 구현에 대한 부분을 숨길 수 있음

 - List는 선형 자료의 추상적인 개념 List 하위에 Stack과 Queue라는 개념이 있음

 - List의 구현은 배열, 연결리스트 모두 가능

```java
public class List<T>{
  AbstractList<T> impl;
  public List(AbstractList<T> list) {
     impl = list;
	}
  public  void add(T obj) {
     impl.addElement(obj);
  }
  public  T get(int i) {
     return impl.getElement(i);
  }
  public  T remove(int i) {
     return impl.deleteElement(i);
  }
  public  int getSize() {
     return impl.getElementSize();
  }
}
```

```java
import impl.AbstractList;

public class Queue<T> extends List<T> {
	public Queue(AbstractList<T> list) {
		super(list);
		System.out.println("Queue를 구현합니다.");
	}
  public void enQueue(T obj) {
     impl.addElement(obj);
	}
  public T deQueue() {
     return impl.deleteElement(0);
	}
}
```

```java
public interface AbstractList<T> {
  public void addElement(T obj);
  public T deleteElement(int i);
  public int insertElement(T obj, int i);
  public T getElement(int i);
  public int getElementSize();
}
```

```java
public class BridgeTest {
	public static void main(String[] args) {
       Queue<String> arrayQueue = new Queue<String>(new ArrayImpl<String>());
       arrayQueue.enQueue("aaa");
       arrayQueue.enQueue("bbb");
       arrayQueue.enQueue("ccc");
       System.out.println(arrayQueue.deQueue());
       System.out.println(arrayQueue.deQueue());
       System.out.println(arrayQueue.deQueue());
       System.out.println("=========================");
       Queue<String> linkedQueue = new Queue<String>(new LinkedListImpl<String>());
       linkedQueue.enQueue("aaa");
       linkedQueue.enQueue("bbb");
       linkedQueue.enQueue("ccc");
       System.out.println(linkedQueue.deQueue());
       System.out.println(linkedQueue.deQueue());
       System.out.println(linkedQueue.deQueue());
       System.out.println("=========================");
       Stack<String> arrayStack = new Stack<String>(new ArrayImpl<String>());
       arrayStack.push("aaa");
       arrayStack.push("bbb");
       arrayStack.push("ccc");
       System.out.println(arrayStack.pop());
       System.out.println(arrayStack.pop());
       System.out.println(arrayStack.pop());
       System.out.println("=========================");
       Stack<String> linkedStack = new Stack<String>(new LinkedListImpl<String>());
       linkedStack.push("aaa");
       linkedStack.push("bbb");
       linkedStack.push("ccc");
       System.out.println(linkedStack.pop());
       System.out.println(linkedStack.pop());
       System.out.println(linkedStack.pop());
       System.out.println("=========================");
	}
}
```