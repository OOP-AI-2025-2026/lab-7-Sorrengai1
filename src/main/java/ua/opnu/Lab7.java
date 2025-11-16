package ua.opnu;

import java.util.*;
import java.util.function.*;

public final class Lab7 {
    private static final int PASSING_MARK = 60;
    private static final int FIRST_ODD_DIVISOR = 3;
    private static final int MAX_DIGIT = 9;
    private static final Predicate<Integer> IS_PRIME = n -> {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = FIRST_ODD_DIVISOR; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    };

    public static Predicate<Integer> getIsPrime() {
        return IS_PRIME;
    }
    public static Student[] filterStudents(final Student[] students,
                                           final Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (predicate.test(student)) {
                result.add(student);
            }
        }
        return result.toArray(new Student[0]);
    }
    public static Student[] filterStudentsWithTwoPredicates(final Student[] students,
                                                            final Predicate<Student> pred1,
                                                            final Predicate<Student> pred2) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (pred1.test(student) && pred2.test(student)) {
                result.add(student);
            }
        }
        return result.toArray(new Student[0]);
    }
    private static final Predicate<Student> NO_DEBTS_PREDICATE = student -> !student.hasDebts();

    public static Predicate<Student> getNoDebtsPredicate() {
        return NO_DEBTS_PREDICATE;
    }
    private static final Consumer<Student> STUDENT_NAME_CONSUMER = student -> {
        String[] names = student.getName().split(" ");
        if (names.length >= 2) {
            System.out.println(
                    names[1].toUpperCase() + " + " + names[0].toUpperCase()
            );
        } else {
            System.out.println(student.getName().toUpperCase());
        }
    };

    public static Consumer<Student> getStudentNameConsumer() {
        return STUDENT_NAME_CONSUMER;
    }

    public static void forEachStudent(final Student[] students,
                                      final Consumer<Student> action) {
        for (Student student : students) {
            action.accept(student);
        }
    }
    public static void processWithCondition(final int[] numbers,
                                            final Predicate<Integer> condition,
                                            final Consumer<Integer> action) {
        for (int number : numbers) {
            if (condition.test(number)) {
                action.accept(number);
            }
        }
    }
    private static final Function<Integer, Integer> POWER_OF_TWO =
            n -> (int) Math.pow(2, n);

    public static Function<Integer, Integer> getPowerOfTwo() {
        return POWER_OF_TWO;
    }

    public static int[] processArray(final int[] input, final Function<Integer, Integer> function) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = function.apply(input[i]);
        }
        return result;
    }
    private static final Function<Integer, String> NUMBER_TO_STRING = n -> {
        String[] numbers = {"нуль", "один", "два", "три", "чотири",
                "п'ять", "шість", "сім", "вісім", "дев'ять"};
        if (n >= 0 && n <= MAX_DIGIT) {
            return numbers[n];
        } else {
            return "невідомо";
        }
    };

    public static Function<Integer, String> getNumberToString() {
        return NUMBER_TO_STRING;
    }

    public static String[] stringify(final int[] numbers,
                                     final Function<Integer, String> function) {
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = function.apply(numbers[i]);
        }
        return result;
    }
}
