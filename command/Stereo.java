package command;

public class Stereo { // Receiver
    String location = "";
    public Stereo(String location) {
        this.location = location;
    }
    public void on() {
        System.out.println(location + " stereo is on");
    }
    public void off() {
        System.out.println(location + " stereo is off");
    }
}
