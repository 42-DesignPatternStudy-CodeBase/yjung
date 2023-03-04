package command;

public class CeilingFan { // Receiver
    String location = "";
    public CeilingFan(String location) {
        this.location = location;
    }
    public void on() {
        System.out.println(location + " ceilingFan is on");
    }
    public void off() {
        System.out.println(location + " ceilingFan is off");
    }
}
