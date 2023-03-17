→ 작은 객체들을 효과적으로 공유하여 사용하기 위한 패턴

→ 반복적으로 쓰이는 작은 객체들 (예를 들어 문자 같은)은 개별 인스턴스로 생성하는 것이 아닌 한번 생성하고 반복적으로 사용할 수 있도록 pool을 관리함

→ 여러개의 객체생성에 대한 초기 비용이 있음

### 언제 사용하나?

---

- 객체마다 인스턴스 값이 다르지 않은 경우가 대부분이고 이런 경우 Singleton pattern으로 생성함

→ 텍스트를 만든다고 할때 각 단어를 객체로 생성하는 것이 아닌 문자를 생성하고 이를 공유하도록 함

→ 이때 필요한 부가적인 정보 (글꼴, 크기등은 부가 정보로 따로 저장함)

```java
// BigString.java
public class BigString { // "큰 문자"의 배열
    private BigChar[] bigchars;
    // 생성자
    public BigString(String string) {
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }
    // 표시
    public void print() {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print();
        }
    } 
}
```

```java
// Main.java
public class Main {
    public static void main(String[] args) {
         BigString bs = new BigString("123abc123");
         bs.print();
    }
}
```

→ 파일에서 숫자를 읽어 BigChar를 만들고 BigCharFActory도 만
들어서 출력하세요