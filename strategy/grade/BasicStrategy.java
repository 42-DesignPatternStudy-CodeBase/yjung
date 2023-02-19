package strategy.grade;

public class BasicStrategy implements Strategy {
    @Override
    public void runStrategy(int scorePoint) {
        if (scorePoint >= 90)
            System.out.print("A");
        else if (scorePoint >= 80)
            System.out.print("B");
        else if (scorePoint >= 70)
            System.out.print("C");
        else if (scorePoint >= 55)
            System.out.print("D");
        else
            System.out.print("F");
    }
}
