package template;

public class ManualCar extends Car{
    @Override
    public void startCar(){
        System.out.println("시동을 켭니다.");
    };

    @Override
    public void drive(){
        System.out.println("사람이 운전합니다.");
    };

    @Override
    public void stop(){
        System.out.println("시동을 끕니다.");
    };

    @Override
    public void turnOff(){
        System.out.println("사람이 핸들을 조작합니다.");
        System.out.println("브레이크를 밟아 정지합니다.");
    };
}