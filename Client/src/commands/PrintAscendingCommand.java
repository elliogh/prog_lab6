package commands;

import utill.CommandReceiver;

import java.io.Serializable;

/**
 * Класс команды print_ascending
 */
public class PrintAscendingCommand implements Command, Serializable {
    private String key = "print_ascending";
    private String helpText = "вывести элементы коллекции в порядке возрастания";

    @Override
    public String execute(CommandReceiver commandReceiver) {
       return commandReceiver.printAscending();
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
