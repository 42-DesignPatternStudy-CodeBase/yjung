package strategy.grade;

public class MajorStrategy implements Strategy {
    @Override
    public void runStrategy(int scorePoint) {
        if (scorePoint >= 95)
            System.out.print("S");
        else if (scorePoint >= 90)
            System.out.print("A");
        else if (scorePoint >= 80)
            System.out.print("B");
        else if (scorePoint >= 70)
            System.out.print("C");
        else if (scorePoint >= 60)
            System.out.print("D");
        else
            System.out.print("F");
    }
}
