package commands;

import collection.Product;
import utill.CommandReceiver;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Класс команды remove_lower_key
 */
public class RemoveLowerKeyCommand implements Command, Serializable{
    private String key = "remove_lower_key";
    private String helpText = "удалить из коллекции все элементы, ключ которых меньше, чем заданный";
    private final int id;
    private static final long serialVersionUID = 6529685098267757690L;

    public RemoveLowerKeyCommand(int id) {
        this.id = id;
    }

    @Override
    public String execute(CommandReceiver commandReceiver) {
        return commandReceiver.removeLowerKey(id);
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
