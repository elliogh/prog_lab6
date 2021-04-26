package commands;

import utill.CommandReceiver;

import java.io.Serializable;

/**
 * Класс команды exit
 */
public class ExitCommand implements Command, Serializable {
    private String key = "exit";
    private String helpText = "завершить программу (без сохранения в файл)";

    @Override
    public String execute(CommandReceiver commandReceiver) {
        return commandReceiver.exit();
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
