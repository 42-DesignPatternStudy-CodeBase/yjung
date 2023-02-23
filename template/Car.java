package template;

public abstract class Car {
    abstract public void drive();
    abstract public void turn();
    abstract public void stop();
    private void startCar() {
        System.out.println("시동을 켭니다.");
    }
    private void turnOff() {
        System.out.println("시동을 끕니다.");
    }
    final void run() {
        startCar();
        drive();
        turn();
        stop();
        turnOff();
    };
}
