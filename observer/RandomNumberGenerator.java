package observer;
import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();
    private int number;

    public int getNumber() {
        return number;
    }

    public void execute() {
        System.out.println("실행했습니다!");
        setNumber();
        notifyObservers();
        System.out.println("=================");
    }

    public void setNumber() {
        number = random.nextInt(30);
    }
}
