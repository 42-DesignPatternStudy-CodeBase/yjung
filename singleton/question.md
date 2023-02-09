```java
public class SingletonTest {
  public static void main(String[] args) {
    Singleton instanceA = Singleton.getInstance();
    Singleton instanceB = Singleton.getInstance();
    System.out.println(instanceA == instanceB);
  }
}
#static
```

→ 위의 코드가 항상 true가 되도록 Singleton Pattern 으로 구현하세요

#static