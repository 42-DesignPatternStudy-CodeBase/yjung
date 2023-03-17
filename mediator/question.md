### **소통은 한군데로 집중해서**

---

→ 여러 객체(Colleague)간의 상호 작용이 많고 이 작용들이 다른 Colleague에도 영향을 줄 때 주로 UI 프로그램에서 많이 사용하는 방법

→ Widget 상호간에 주과 받아야하는 메세지가 많은 경우, 이를 한 객체(Mediator)에서 전담하여 메세지를 처리하도록 함

→ N:N의 관계가 1:N으로 줄어드는 효과 (counselor)

ConcreteMediator : Colleague간의 이루어지는 협력을 구현하고, 자신의 Colleague들을 관리한다.

Colleague : Mediator의 참조자를 가지고 있고, 자신의 상태가 변하거나 다른 객체와의 협력이 필요할때 Mediator에게 알림

```java
// Mediator.java
public interface Mediator {
    public abstract void createColleagues();
    public abstract void colleagueChanged(Colleague colleague);
}
```

```java
// Colleague.java
public interface Colleague {
    public abstract void setMediator(Mediator mediator);
    public abstract void setColleagueEnabled(boolean enabled);
}
```

```java
// ColleagueButton.java
public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;
    public ColleagueButton(String caption) {
        super(caption);
    }
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
```

```java
// LoginFrame.java
public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // 생성자
    // Colleague들을 생성해서 배치한 후에 표시를 실행한다.
    public LoginFrame(String title) {
        super(title);
        //**1-1**
        //도화지깔기 
        setBackground(Color.lightGray);
        // 레이아웃 매니저를 사용해서 4*2의 그리드를 만든다. 
        setLayout(new GridLayout(4, 2));
        
        //**1-2**
        // Colleague들의 생성
        createColleagues();
        
        //**1-3**
        // 배치
        //check box
        add(checkGuest);
        add(checkLogin);
        
        // textbox
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        
        // button
        add(buttonOk);
        add(buttonCancel);
        
        //**1-4**
        // 유효/무효의 초기지정 
        colleagueChanged(checkGuest);
        // 표시
        pack();
        show();
    }

    // Colleague들을 생성한다.
    public void createColleagues() {
    	//**2-1**
        //객체 생성
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel"); 
        
        //**2-2**
        // Mediator의 셋팅 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this); 
        textUser.setMediator(this);
        textPass.setMediator(this); 
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        //**2-3**
        // Listener의 세트 
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin); 
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass); 
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleague로부터의 통지로 각 Colleague의 유효/무효를 판정한다.
    public void colleagueChanged(Colleague c) {
        if (c == checkGuest || c == checkLogin) {
            if (checkGuest.getState()) {
                textUser.setColleagueEnabled(false);
                textPass.setColleagueEnabled(false);
                buttonOk.setColleagueEnabled(true);
            } else {
                textUser.setColleagueEnabled(true);
                userpassChanged();
            }
        } else if (c == textUser || c == textPass) {
            userpassChanged();
        } else {
            // Guest 모드 // Login 모드
            System.out.println("colleagueChanged:unknown colleague = " + c);
        }
    }

    // textUser 또는 textPass의 변경이 있었다. 
    // 각 Colleague의 유효/무효를 판정한다.
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("" + e);
        System.exit(0);
    }

}
```

```java
// Main.java
public class Main {
    static public void main(String args[]) {
        new LoginFrame("Mediator Sample");
    }
}
```