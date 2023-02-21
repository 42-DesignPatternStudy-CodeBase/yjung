### 객체를 일괄적으로 관리하는 방법?

- Aggregator

  → 배열, 연결리스트, 등등. 집합체

- Iterator

  → 객체 내부 구현을 외부로 노출하지 않고 접근하게 하기위한 설계


### 단일 역할의 원칙

→ 어떤 클래스가 하나 이상의 역할을 제공하게 되면 변경의 이유도 하나 이상이 된다.

→ 클래스가 변경되는 이유는 하나 뿐이어야 한다. 집합체가 순회에 대한 구현까지 한다면 집합체의 기능과 순회의 기능을 모두 제공하는 것이다.


```java
public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}

public interface Aggregate {
    public abstract Iterator iterator();
    public int getLength();
}

public class Book {
    private String name;
    public Book(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
```

- Iterator 인터페이스를 구현한 BookShelfIterator 만들기

```java
public static void main(String[] args) {
    BookShelf bookShelf = new BookShelf(4);
    bookShelf.appendBook(new Book("Around the World in 80 Days"));
    bookShelf.appendBook(new Book("Bible"));
    bookShelf.appendBook(new Book("Cinderella"));
    bookShelf.appendBook(new Book("Daddy-Long-Legs"));
    Iterator it = bookShelf.iterator();
    while (it.hasNext()) {
        Book book = (Book)it.next();
        System.out.println("" + book.getName());
    }
}
   ```

- 역순으로 순회하는 ReverseIterator 만들기
- 다양한 Iterator가 만들어 지는 Factory를 만들어 적용해보기

```java

public abstract class Factory {
    public final Iterator create(Aggregate list, int type) {
        Iterator p = createProduct(list, type);
        return p;
    }
    protected abstract Iterator createProduct(Aggregate list, int type);
}
   ```