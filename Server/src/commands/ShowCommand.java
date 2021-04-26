package commands;

import collection.Product;
import utill.CommandReceiver;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Класс команды show
 */
public class ShowCommand implements Command, Serializable {
    private String key = "show";
    private String helpText = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

    @Override
    public String execute(CommandReceiver commandReceiver) {
        return commandReceiver.show();
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
