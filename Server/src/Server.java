import collection.Product;
import utill.Controller;
import utill.JsonParser;

import java.util.*;

public class Server{

    public static void main(String[] args) {
//        String path = "./src/input_file.json";
//        JsonParser jsonParser = new JsonParser();
//        TreeMap<Integer, Product> collection = jsonParser.jsonFileToCollection(path);
//        for (Map.Entry<Integer, Product> e : collection.entrySet()) {
//            System.out.println(e.getValue());
//        }

        System.out.println("Начало работы сервера:");
        int port = askPort();
        Controller controller = new Controller(port);
        controller.run();
    }

    public static int askPort(){
        Scanner consoleScanner = new Scanner(System.in);
        int port = 0;
        String input;
        System.out.print("Введите порт: ");
        input = consoleScanner.nextLine();
        try {
            port = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Неправильный порт");
            System.exit(1);
        }
        return port;
    }

}