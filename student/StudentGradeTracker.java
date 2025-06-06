import java.util.*;

class Student {
    String name;
    ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
return grades.isEmpty() ? 0 : (double) sum / grades.size();
    }

    public int getHighest() {
        return grades.isEmpty() ? 0 : Collections.max(grades);
    }

    public int getLowest() {
        return grades.isEmpty() ? 0 : Collections.min(grades);
    }

    @Override
    public String toString() {
        return name + " → Grades: " + grades +
               " | Avg: " + String.format("%.2f", getAverage()) +
               " | High: " + getHighest() +
               " | Low: " + getLowest();
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            Student s = new Student(name);
System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = scanner.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                s.addGrade(grade);
            }

            scanner.nextLine(); // consume newline
            students.add(s);
        }

        System.out.println("\n--- Student Summary ---");
        for (Student s : students) {
            System.out.println(s);
        }

        scanner.close();
    }
}