package ui;

public class CommandResult {

    private final Command command;
    private final String result;

    public CommandResult(Command command, String result) {
        this.command = command;
        this.result = result;
    }

    public Command getCommand() {
        return command;
    }

    public String getResult() {
        return result;
    }
}
