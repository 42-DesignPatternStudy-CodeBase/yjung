package strategy_1;
import java.util.ArrayList;

public class Student {
    int studentID;
    String studentName;
    ArrayList<Subject> subjectList;

    public static final int BASIC = 0;
    public static final int MAJOR = 1;
    public Student(int studentID, String studentName){
        this.studentID = studentID;
        this.studentName = studentName;
        subjectList = new ArrayList<Subject>();
    }
    public void addSubject(String name, int score, boolean majorCode){
        Subject subject = new Subject();
        subject.setName(name);
        subject.setScorePoint(score);
        subject.setMajorCode(majorCode);
        subjectList.add(subject);
    }

    public void showGradeInfo() {
        for (int i = 0;  i < subjectList.size(); i++) {
            System.out.print("학생 " + this.studentName + "의 ");
            System.out.print(this.subjectList.get(i).getName() + " 과목 성적은 ");
            System.out.print(this.subjectList.get(i).getScorePoint() + "이고, 학점은 ");
            this.checkStrategy(this.subjectList.get(i).isMajorCode(), this.subjectList.get(i).getScorePoint());
            System.out.println(" 입니다.");
        }
    }

    public void checkStrategy(boolean isMajorCode, int scorePoint) {
        Strategy strategy = null;
        if (isMajorCode)
            strategy = new MajorStrategy();
        else
            strategy = new BasicStrategy();
        strategy.runStrategy(scorePoint);
    }
}
