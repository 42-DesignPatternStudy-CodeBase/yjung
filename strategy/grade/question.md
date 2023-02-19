
### 정책이나 알고리즘을 분리하여 대체 가능하도록하는 strategy pattern

---
학교의 학생이 수강 신청을 하게되면 과목마다 각각 성적을 받게 된다.

이때, 성적에 대한 학점을 부여하는 정책은 다음과 같이 여러가지가 있을 수 있다.

전공 관련 여부에 따라 학점이 다르게 부여되는 경우,
Pass/Fail로 만 학점을 부여하는 경우등 다양한 학점에 대한 정책이 있을때 각 성적에 대해 다양한 정책을 어떻게 구현하면 좋을까?

아래 코드에 성적의 정책을 추가하여 다음과 같은 리포트를 구현하세요.

```java
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
}
public class Subject {
    private String name;
    private int scorePoint;
    private boolean majorCode;
    
    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }
    public int getScorePoint() {
    return scorePoint;
    }
    public void setScorePoint(int scorePoint) {
    this.scorePoint = scorePoint;
    }
    public boolean isMajorCode() {
    return majorCode;
    }
    public void setMajorCode(boolean majorCode) {
    this.majorCode = majorCode;
    }
}

public class StudentTest {
    public static void main(String[] args) {
        Student studentLee = new Student(1001, "Lee");
        studentLee.addSubject("국어", 100, false);
        studentLee.addSubject("수학", 100, true);
        Student studentKim = new Student(1002, "Kim");
        studentKim.addSubject("국어", 55, true);
        studentKim.addSubject("수학", 55, false);
        studentKim.addSubject("영어", 100, false);
        studentLee.showGradeInfo();
        System.out.println("======================================");
        studentKim.showGradeInfo();
    }
}
```
``` 
학생 Lee의 국어 과목성적은 100점 이고, 학점은 A 입니다.
학생 Lee의 수학 과목성적은 100점 이고, 학점은 S 입니다.
======================================
학생 Kim의 국어 과목성적은 55점 이고, 학점은 F 입니다.
학생 Kim의 수학 과목성적은 55점 이고, 학점은 D 입니다.
학생 Kim의 영어 과목성적은 100점 이고, 학점은 A 입니다.
```