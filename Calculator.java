import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    // Список для хранения истории операций
    private static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        System.out.println("=== Калькулятор с историей ===");
        System.out.println("Доступные операции: +, -, *, /");
        System.out.println("Команды: 'history' - показать историю, 'exit' - выход");

        while (run) {
            System.out.println("\nВведите выражение (например: 2 + 2): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                run = false;
                System.out.println("До свидания!");
            } else if (input.equalsIgnoreCase("history")) {
                showHistory();
            } else {
                try {
                    double result = calculateExpression(input);
                    System.out.println("Результат: " + result);
                    history.add(input + " = " + result);
                } catch (Exception e) {
                    System.out.println("Ошибка!");
                }
            }
        }
        scanner.close();
    }

    // Метод для вычисления выражений
    private static double calculateExpression(String input) {
        String[] parts = input.split("(?=[-+*/])|(?<=[-+*/])");;
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат");
        }
        double a = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double b = Double.parseDouble(parts[2]);

        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Деление на ноль.");
                return a / b;
            default:
                throw new UnsupportedOperationException("Неизвестная операция");
        }
    }

    // Метод для показа истории
    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("История пуста.");
        } else {
            System.out.println("\n=== Bcnjhbz jgthfwbq ===");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }
}
