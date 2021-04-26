package commands;

import collection.Product;
import utill.CommandReceiver;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Класс команды save
 */
public class SaveCommand implements Command, Serializable {
    private String key = "save";
    private String helpText = "сохранить коллекцию в файл";

    @Override
    public String execute(CommandReceiver commandReceiver) {
        return "to be continued";//CommandReceiver.save();
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
