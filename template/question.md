### 추상 클래스와 template method
```java
public class CarTest {
    public static void main(String[] args) {
        Car aiCar = new AICar();
        aiCar.run();
        System.out.println("===============");
        Car manualCar = new ManualCar();
        manualCar.run();
    }
}
```
```
시동을 켭니다.
자율 주행 합니다.
자동차가 스스로 방향을 바꿉니다.
스스로 멈춥니다.
시동을 끕니다.
===============
시동을 켭니다.
사람이 운전합니다.
사람이 핸들을 조작합니다.
브레이크를 밟아 정지합니다.
시동을 끕니다.
```
#추상클래스 #추상메서드. #Hook메서드. #final키워드