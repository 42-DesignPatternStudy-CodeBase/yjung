### 명령을 캡슐화 하기

---

→ 다양하게 처리되어야 하는 메뉴, 요청이 있을 때 이를 동일한 방식으로 처리될 수 있도록 함

→ 명령을 보내는 쪽과 명령을 처리하는 쪽을 분리한다 (느슨한 구조)

→ 여러 다른 명령 기능이 추가 되더라도 처리하는 방식이 동일하다.

→ Command 내부에서 요청을 처리할 대상 (receiver)에 대한 정보를 가지고 있어야 한다.

→ 처리된 명령에 대한 히스토리가 유지되면 롤백할 수 있다.

→ 여러개의 요청을 한꺼번에 일괄적으로 처리 할 수도 있다. (macro commnad)

```
리모컨의 버튼들은 (invoker) 각각 다른 대상(receiver)에 대한 수행을 요구한다고 하면 이를 어떻게 처리할 것인가?
0번 버튼 눌리면 (ON): 불을 켠다
0번 버튼 올라오면 (OFF) : 불을 끈다
1번 버튼 눌리면 (ON) : 에어켠이나 히터를 켠다
1번 버튼 올라오면 (OFF) : 에어켠이나 히터를 끈다
2번 버튼 눌리면 (ON) : 음악을 켠다
2번 버튼 올라오면 (OFF) : 음악을 끈다
3번 버튼 눌리면 (ON): 문을 연다
3번 버튼 올라오면 (OFF) : 문들 닫는다
```

```java
public interface Command { 
    public void execute();
}
```

```java
public class Light {
	String location = "";
	public Light(String location) {
		this.location = location;
	}
	public void on() {
		System.out.println(location + " light is on");
	}
	public void off() {
		System.out.println(location + " light is off");
	}
}
```

```java
public class GarageDoor {
	String location;
	public GarageDoor(String location) {
		this.location = location;
	}
	public void up() {
		System.out.println(location + " garage Door is Up");
	}
	public void down() {
		System.out.println(location + " garage Door is Down");
	}
	public void stop() {
		System.out.println(location + " garage Door is Stopped");
	}
	public void lightOn() {
		System.out.println(location + " garage light is on");
	}
	public void lightOff() {
		System.out.println(location + " garage light is off");
	}
}
```

```java
public class LightOnCommand implements Command { 
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
	}
    public void execute() {
        light.on();
	}
}
```

```java
public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light livingRoomLight = new Light("Living Room");
        CeilingFan ceilingFan= new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("Garage");
        Stereo stereo = new Stereo("Living Room");
        LightOnCommand livingRoomLightOn =
                new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff =
                new LightOffCommand(livingRoomLight);
        CeilingFanOnCommand ceilingFanOn = 
                new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = 
                new CeilingFanOffCommand(ceilingFan);
        GarageDoorUpCommand garageDoorUp = 
                new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = 
                new GarageDoorDownCommand(garageDoor);
        StereoOnWithCDCommand stereoOnWithCD = 
                new StereoOnWithCDCommand(stereo);
        StereoOffCommand  stereoOff = 
                new StereoOffCommand(stereo);
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);
        remoteControl.setCommand(3, garageDoorUp, garageDoorDown);
        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
	}
}
```