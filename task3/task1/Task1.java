package task1;
public class Task1 {
    public static void main(String[] args) {
        int number1 = 100 + (new java.util.Random()).nextInt(900);
        int number2 = 100 + (new java.util.Random()).nextInt(900);
        int number3 = 100 + (new java.util.Random()).nextInt(900);

        System.out.println("Случайные трёхзначные числа:");
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);

        // Получаем первую цифру каждого числа через строку
        int firstDigit1 = Character.getNumericValue(String.valueOf(number1).charAt(0));
        int firstDigit2 = Character.getNumericValue(String.valueOf(number2).charAt(0));
        int firstDigit3 = Character.getNumericValue(String.valueOf(number3).charAt(0));

        int sum = firstDigit1 + firstDigit2 + firstDigit3;

        System.out.println("Сумма первых цифр: " + sum);
    }
}