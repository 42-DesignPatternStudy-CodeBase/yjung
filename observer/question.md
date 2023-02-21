## 변화를 다른 객체들! 에게 알려주는 - Observer 패턴

---

느슨한 결합 (Loose Coupling) : 상호 작용하는 객체 사이에는 가능한 느슨한 결합이 중요

객체 사이에 일대 다의 의존 관계가 있고, 어떤 객체의 상태가 변하면 그 객체에 의존성을 가진 다른 객체들에게 변화를 통지 (notify or update) 하여 자동으로 갱신하게 됨

날씨(data)와 이것을 보여주는 여러 개의 그래프, 대시보드(view) Log의 내용을 기록하는 Handler 가 여러 개인 경우
이때 중요한 것 변화에 관심을 가지고 그 정보를 업데이트 해야 하는 객체가 몇개냐와는 상관없이 일괄적으로 메세지가 전송되어야 함

변화 되는 객체 (Subject) - 이 데이터를 활용하는 객체들 (Observer) 의 관계는 느슨한 결합이어야 함

Pull or Push
MVC. Document- View
```java
public abstract class NumberGenerator {
    private List<Observer> observers = new ArrayList<Observer>();
    
    public void addObserver(Observer observer) {
    observers.add(observer);
    }
    public void deleteObserver(Observer observer) {
    observers.remove(observer);
    }
    public void notifyObservers() {
        // ToDo
    }
    public abstract int getNumber();
    public abstract void execute();
}

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();
    private int number;
    
    public int getNumber() {
        return number;
    }
    public void execute() {
        //ToDo
    } 
}
    
public interface Observer {
    public abstract void update(NumberGenerator generator);
}
```
옵저버들을 만들고 Main이 수행되도록 해보세요
```java
public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        // ToDo 
    }
}
```