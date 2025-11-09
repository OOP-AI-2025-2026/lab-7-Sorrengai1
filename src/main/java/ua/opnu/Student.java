package ua.opnu;
import java.util.Arrays;

public class Student {
    private String name;
    private String group;
    private int[] marks;

    private static final int PASSING_MARK = 60;
    public Student(final String name, final String group, final int[] marks) {
        this.name = name;
        this.group = group;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }
    public String getGroup() {
        return group;
    }
    public int[] getMarks() {
        return marks;
    }

    public boolean hasDebts() {
        for (int mark : marks) {
            if (mark < PASSING_MARK) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " (" + group + ") - " + Arrays.toString(marks);
    }
}
