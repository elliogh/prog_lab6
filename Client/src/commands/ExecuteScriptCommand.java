package commands;

import utill.CommandReceiver;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Класс команды execute_script
 */
public class ExecuteScriptCommand implements Command, Serializable {
    private String key = "execute_script";
    private String helpText = "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    private ArrayList<String> script;
    private static final long serialVersionUID = 6529685098267757690L;

    public ExecuteScriptCommand(ArrayList<String> script) {
        this.script = script;
    }

    @Override
    public String execute(CommandReceiver commandReceiver) {
        return commandReceiver.executeScript();
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
