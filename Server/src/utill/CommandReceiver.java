package utill;

import collection.Person;
import collection.Product;
import commands.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CommandReceiver {
    private TreeMap<Integer, Product> collection;
    private LocalDate initDate;
    private HashSet<Command> commandSet = new HashSet<>();

    public CommandReceiver() {
        initDate = LocalDate.now();
        collection = new JsonParser().jsonFileToCollection("./src/input_file.json");
        addCommands(
                new HelpCommand(),
                new InfoCommand(),
                new ShowCommand(),
                new InsertCommand(0, null),
                new RemoveKeyCommand(0),
                new ClearCommand(),
                new ExecuteScriptCommand(null),
                new ExitCommand(),
                new RemoveLowerCommand(null),
                new ReplaceIfGreaterCommand(0, null),
                new RemoveLowerKeyCommand(0),
                new RemoveAllByOwnerCommand(null),
                new PrintAscendingCommand(),
                new PrintDescendingCommand()
        );

    }

    public TreeMap<Integer, Product> getCollection() {
        return collection;
    }

    public String help() {
        return commandSet.stream()
                .map(command -> Clr.ANSI_YELLOW + command.getKey() + Clr.ANSI_RESET + " : " + command.getHelpText())
                .collect(Collectors.joining("\n"));
    }

    public String info() {
        for (Map.Entry<Integer, Product> e : collection.entrySet()) {
            if (e.getValue() == null) {
                System.out.println(Clr.ANSI_RED + "Ошибка" + Clr.ANSI_RESET);
                System.exit(1);
            }
        }
        return  Clr.ANSI_BLUE + "\nТип коллекции: " + Clr.ANSI_RESET + getCollectionType() +
                Clr.ANSI_BLUE + "\nДата инициализации: " + Clr.ANSI_RESET + getInitDate() +
                Clr.ANSI_BLUE + "\nКоличество элементов: " + Clr.ANSI_RESET + getNumberOfElements();
    }

    public String show() {
        if (!collection.isEmpty())
            return collection.values().stream()
                    .map(Product::toString)
                    .collect(Collectors.joining("\n"));
        else return "Коллекция пуста";
    }

    public String insert(int id, Product product) {
        collection.put(id, product);
        return "Элемент добавлен в коллекцию";
    }

    public String update(int id, Product product) {
        if (collection.containsKey(id)) {
            collection.replace(id, product);
            return "Элемент обновлен";
        } else return "Элемента с таким ключом не существует";
    }

    public String removeKey(int id) {
        if (collection.containsKey(id)) {
            collection.remove(id);
            return "Команда успешно выполнена";
        }
        else return "Элемента с таким ключом не существует";
    }

    public String clear() {
        collection.clear();
        return "Коллекция очищена";
    }

    public String executeScript(ArrayList<String> list) {
        return null;
    }

    public String exit() {
        return null;
    }

    public String removeLower(Product product) {
        HashSet<Integer> keys = new HashSet<>();
        for (Map.Entry<Integer, Product> e : collection.entrySet()) {
            if (e.getValue().hashCode() - product.hashCode() < 0) keys.add(e.getKey());
        }
        for (Integer s : keys) {
            collection.remove(s);
        }
        return "Команда успешно выполнена";
    }

    public String replaceIfGreater(int id, Product product) {
        if (collection.containsKey(id)) {
            if (collection.get(id).hashCode() - product.hashCode() < 0) {
                collection.replace(id, product);
            }
            return "Команда успешно выполнена";
        }
        else return "Элемента с таким ключом не существует";
    }

    public String removeLowerKey(int id) {
        HashSet<Integer> keys = new HashSet<>();
        for (Map.Entry<Integer, Product> e : collection.entrySet()) {
            if (e.getKey() < id) keys.add(e.getKey());
        }

        for (Integer s : keys) {
            collection.remove(s);
        }
        return "Команда успешно выполнена";
    }

    public String removeAllByOwner(Person owner) {
        HashSet<Integer> keys = new HashSet<>();
        for (Map.Entry<Integer, Product> e : collection.entrySet()) {
            if (owner.equals(e.getValue().getOwner())) {
                keys.add(e.getKey());
            }
        }

        for (Integer s : keys) {
            collection.remove(s);
        }
        return "Команда успешно выполнена";
    }

    public String printAscending() {
        if (!collection.isEmpty()) return collection.values().stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
        else return "Коллекция пуста";
    }

    public String printDescending() {
        if (!collection.isEmpty()) return collection.values().stream()
                .sorted(Comparator
                        .comparing(Product::getPrice)
                        .reversed())
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
        else return "Коллекция пуста";
    }

    /**
     * Метод, возвращающий тип коллекции
     * @return тип колекции
     */
    public String getCollectionType() {
        return collection.getClass().getSimpleName();
    }

    /**
     * Метод, возвращающий дату инициализации коллекции
     * @return initDate
     */
    public LocalDate getInitDate() {
        return initDate;
    }

    /**
     * Метод, возвращающий количество элементов коллеции
     * @return размер коллекции
     */
    public int getNumberOfElements() {
        return collection.size();
    }

    private void addCommands(Command ... commands) {
        for (Command command : commands) {
            commandSet.add(command);
        }
    }

}
