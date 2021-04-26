package commands;

import utill.CommandReceiver;

import java.io.Serializable;

/**
 * Класс команды clear
 */
public class ClearCommand implements Command, Serializable {
    private String key = "clear";
    private String helpText = "очистить коллекцию";

    @Override
    public String execute(CommandReceiver commandReceiver) {
        return commandReceiver.clear();
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getHelpText() {
        return helpText;
    }
}
