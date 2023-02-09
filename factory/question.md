```java
public  class Car {
	public static final String SONATA = "Sonata";
	public static final String GRANDEUR = "Grandeur";
	public static final String GENESIS = "Genesis";
	String productName;
	public Car(String productName) {
		this.productName = productName;
	}
	public String toString() {
		return productName;
	}
}

public class CarTest {
	public static void main(String[] args) {
		CarTest test = new CarTest();
		Car car = test.produceCar("Sonata");
		System.out.println(car);
	}
	public Car produceCar(String name) {
		Car car = null;
		if( name.equalsIgnoreCase(Car.SONATA)) {
			car = new Car(Car.SONATA);
		}
		else if( name.equalsIgnoreCase(Car.GRANDEUR)) {
			car = new Car(Car.GRANDEUR);
		}
		else if( name.equalsIgnoreCase(Car.GENESIS)) {
			car = new Car(Car.GENESIS);
		}
		else {
			car = new Car("noname");
		}
		return car;
	}
}
```
-> 다음 코드를 상속과 Factory pattern 을 이용하여 리펙토링 하세요