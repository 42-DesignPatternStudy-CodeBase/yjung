package command;

public class LightOnCommand implements Command { // ConcreteCommand
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
}
