package observer;

public class GraphObserver implements Observer {
    private int status;

    @Override
    public void update(NumberGenerator generator) {
        this.status = generator.getNumber();
        if (status > 20) {
            System.out.println("###");
        } else if (status > 10) {
            System.out.println("##");
        } else {
            System.out.println("#");
        }
    }
}