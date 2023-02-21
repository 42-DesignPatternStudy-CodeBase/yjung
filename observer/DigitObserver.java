package observer;

public class DigitObserver implements Observer {
    private int status;

    @Override
    public void update(NumberGenerator generator) {
        this.status = generator.getNumber();
        System.out.println("현재 숫자는 " + status + "입니다");
    }
}
