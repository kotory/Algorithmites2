import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();

        int closestSquare = findClosestSquare(n);

        System.out.println("Число, квадрат которого будет являться ближайшим к заданному числу: " + closestSquare);
    }

    // Метод для нахождения ближайшего квадрата к заданному числу n
    public static int findClosestSquare(int n) {
        if (n <= 0) {
            return 0; // если n не положительное, возвращаем 0 (невозможно найти квадрат)
        }

        // Инициализируем переменные для хранения ближайшего квадрата и его разницы с n
        int closestSquare = 0;
        int minDifference = Integer.MAX_VALUE;

        // Перебираем все целые числа, начиная с 1, и находим квадраты ближе к n
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            int difference = Math.abs(square - n);

            // Если найдена новая более близкая разница, обновляем ближайший квадрат и разницу
            if (difference < minDifference) {
                closestSquare = square;
                minDifference = difference;
            }
        }

        return (int) Math.sqrt(closestSquare);
    }
}