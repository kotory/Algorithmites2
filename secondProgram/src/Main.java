import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку символов: ");
        String input = scanner.nextLine();

        String result = convertCase(input);

        System.out.println("Преобразованная строка: " + result);
    }

    // Метод для преобразования строки в соответствии с условиями задачи
    public static String convertCase(String input) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;

        // Подсчитываем количество заглавных и строчных букв в строке
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(ch)) {
                lowercaseCount++;
            }
        }

        // Преобразование строки в зависимости от количества заглавных и строчных букв
        if (uppercaseCount > lowercaseCount) {
            // Если заглавных больше, преобразуем строку к верхнему регистру
            return input.toUpperCase();
        } else if (lowercaseCount > uppercaseCount) {
            // Если строчных больше, преобразуем строку к строчному регистру
            return input.toLowerCase();
        } else {
            // Если равное количество, преобразуем строку к строчному регистру
            return input.toLowerCase();
        }
    }
}