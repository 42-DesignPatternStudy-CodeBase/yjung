package command;

public class RemoteControl { // Invoker
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl(){
        onCommands = new Command[5];
        offCommands= new Command[5];
    }
    public void setCommand(int command, Command onCommand, Command offCommand){
        onCommands[command] = onCommand;
        offCommands[command] = offCommand;
    }
    public void onButtonWasPushed(int command){
        if (onCommands[command] != null)
            onCommands[command].execute();
    }
    public void offButtonWasPushed(int command){
        if (offCommands[command] != null)
            offCommands[command].execute();
    }
}
