import lesson_3.GenericClass;
import lesson_3.ICheckingDivisibility;
import lesson_3.IDiscrimCalc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Задание 1");
        System.out.println("Введите 2 целых числа");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        GenericClass<Integer> test = new GenericClass<>(num1, num2);
        System.out.printf("Максимальное число равно " + test.getMax());
        System.out.println();
        System.out.println();

        System.out.println("Задание 2");
        System.out.println(
                "Введите 1 целое число, и тогда узнаете, делится ли оно на 13"
        );
        num1 = in.nextInt();
        ICheckingDivisibility check = num -> num % 13 == 0;
        System.out.println(check.check(num1));
        System.out.println();

        System.out.println("Задание 3");
        System.out.println(
                "Введите 3 вещественных числа для вычисления дискриминанта"
        );
        float a = in.nextFloat();
        float b = in.nextFloat();
        float c = in.nextFloat();
        IDiscrimCalc dc = (A, B, C) -> B * B - 4 * A * C;
        System.out.println("Дискриминант равен " + dc.calc(a, b, c));

        in.close();
    }
}
