package template;

public abstract class Car {
    abstract public void startCar();
    abstract public void drive();
    abstract public void stop();
    abstract public void turnOff();

    final void run() {
        startCar();
        drive();
        turnOff();
        stop();
    };
}
