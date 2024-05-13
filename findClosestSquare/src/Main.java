import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();

        int closestSquare = findClosestSquare(n);

        System.out.println("Число, квадрат которого будет являться ближайшим к заданному числу: " + closestSquare);
    }

    public static int findClosestSquare(int n) {
        if (n <= 0) {
            return 0;
        }

        int closestSquare = 0;
        int minDifference = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            int difference = Math.abs(square - n);

            if (difference < minDifference) {
                closestSquare = square;
                minDifference = difference;
            }
        }

        return (int) Math.sqrt(closestSquare);
    }
}