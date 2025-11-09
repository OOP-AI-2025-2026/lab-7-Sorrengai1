package ua.opnu;

import java.util.function.Predicate;
import java.util.function.Consumer;

public class Main {
    public static void main(final String[] args) {
        System.out.println("*Завдання 1: Перевірка простих чисел*");
        int[] testNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19};
        for (int num : testNumbers) {
            System.out.println(num + " просте: " + Lab7.getIsPrime().test(num));
        }

        System.out.println("\n*Завдання 2: Фільтрація студентів*");
        Student[] students = {
                new Student("Андрей Оліник", "Група АІ-243", new int[]{85, 90, 78, 92}),
                new Student("Юлія Середа", "Група АІ-241", new int[]{45, 75, 82, 91}),
                new Student("Петро Сидоренко", "Група НАІ-240", new int[]{95, 88, 79, 65}),
                new Student("Олена Коваленко", "Група АІ-243", new int[]{58, 62, 71, 84}),
                new Student("Андрій Шевченко", "Група P-23", new int[]{91, 87, 93, 89})
        };

        System.out.println("Всі студенти:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nСтуденти без заборгованостей:");
        Student[] filteredStudents = Lab7.filterStudents(students, Lab7.getNoDebtsPredicate());
        for (Student student : filteredStudents) {
            System.out.println(student);
        }

        System.out.println("\n*Завдання 3: Фільтрація за двома умовами*");
        Predicate<Student> groupAPredicate = student -> student.getGroup().equals("Група АІ-243");

        Student[] doubleFiltered = Lab7.filterStudentsWithTwoPredicates(
                students, Lab7.getNoDebtsPredicate(), groupAPredicate);
        System.out.println("Студенти групи АІ-243 без заборгованостей:");
        for (Student student : doubleFiltered) {
            System.out.println(student);
        }

        System.out.println("\n*Завдання 4: Consumer для студентів*");
        System.out.println("Вивід у форматі ПРІЗВИЩЕ + ІМ'Я:");
        Lab7.forEachStudent(students, Lab7.getStudentNameConsumer());

        System.out.println("\n*Завдання 5: Predicate + Consumer*");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        Consumer<Integer> squareConsumer = n -> System.out.println(n + "^2 = " + (n * n));

        System.out.println("Квадрати парних чисел:");
        Lab7.processWithCondition(numbers, evenPredicate, squareConsumer);

        System.out.println("\n*Завдання 6: Function 2^n*");
        int[] inputNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] poweredNumbers = Lab7.processArray(inputNumbers, Lab7.getPowerOfTwo());

        System.out.println("Результати 2^n:");
        for (int i = 0; i < inputNumbers.length; i++) {
            System.out.println("2^" + inputNumbers[i] + " = " + poweredNumbers[i]);
        }

        System.out.println("\n*Завдання 7: Перетворення чисел в слова*");
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] stringResults = Lab7.stringify(digits, Lab7.getNumberToString());

        System.out.println("Числа словами:");
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i] + " -> " + stringResults[i]);
        }
    }
}
