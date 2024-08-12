import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char action = input.replaceAll(".*?([+\\-*/]) .*", "$1").trim().charAt(0);
        String[] data = input.split(" [+\\-*/] ");
        if (data.length < 2)
            throw new Exception("Ввод неправильного действия или формата строки");
        if (!(data[0].contains("\"")))
            throw new Exception("Число не должно быть первым");
        if ((action == '*' || action == '/') && (data[1].contains("\"")))
            throw new Exception("Строчку можно делить и умножать только на число");
        if (data[0].length() > 12 || data[1].length() > 12)
            throw new Exception("Длинна строки должна быть не больше 10 символов, не считая кавычки");
        if (!(data[1].contains("\"")) && (Integer.parseInt(data[1]) > 10 || Integer.parseInt(data[1]) < 1))
            throw new Exception("Число должно быть от 1 до 10 включительно");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].trim().replaceAll("\"", "");
        }
        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            printInQuotes(data[0].repeat(Integer.parseInt(data[1])));
        } else if (action == '-') {
            printInQuotes(data[0].replaceAll(data[1], ""));

        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            printInQuotes( data[0].substring(0, newLen));
        }


    }

    static void printInQuotes(String text) {
        if (text.length() >= 40) {
            text = text.substring(0, 40) + "...";
        }
        System.out.println("\"" + text + "\"");
    }
}