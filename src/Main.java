import lesson_4.Student;
import lesson_4.StudentCollection;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentCollection students = new StudentCollection();

        Student student1 = new Student("Ваня", "ПИ-3", 3);
        student1.getMarks().put("МИИ", 4);
        student1.getMarks().put("РИАТ", 5);
        student1.getMarks().put("КОП", 4);
        Student student2 = new Student("Алина", "ПИ-2", 3);
        student2.getMarks().put("МИИ", 5);
        student2.getMarks().put("РИАТ", 5);
        student2.getMarks().put("КОП", 4);
        Student student3 = new Student("Игорь", "ИСЕ-1", 2);
        student3.getMarks().put("МИИ", 4);
        student3.getMarks().put("РИАТ", 5);
        student3.getMarks().put("КОП", 5);
        Student student4 = new Student("Егор", "ПИ-3", 3);
        student4.getMarks().put("МИИ", 3);
        student4.getMarks().put("РИАТ", 2);
        student4.getMarks().put("КОП", 3);

        students.addStudent(student1);
        students.addStudent(student2);
        students.addStudent(student3);
        students.addStudent(student4);

        printStudents(students.getStudents(), 2);
        printStudents(students.getStudents(), 3);
        students.updateStudentsData();
        printStudents(students.getStudents(), 3);
        printStudents(students.getStudents(), 4);
    }

    public static void printStudents(
            List<Student> students, int course) {
        System.out.println(
                "Студенты, обучающиеся на курсе " + course + ":");
        for (Student student : students){
            if(student.getCourse() == course)
                System.out.println(student.getName());
        }
    }
}
