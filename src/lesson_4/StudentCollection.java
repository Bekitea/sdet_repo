package lesson_4;

import java.util.ArrayList;
import java.util.List;

public class StudentCollection {
    private List<Student> students = new ArrayList<>();

    public StudentCollection() {}

    public StudentCollection(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudentsData(){
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            double marksSum = student.getMarks()
                    .values().stream()
                    .mapToDouble(Integer::doubleValue).sum();
            double marksNumber = student.getMarks().size();
            double averageMark = marksSum / marksNumber;
            if(averageMark < 3.0){
                students.remove(i);
                i--;
            }
            else{
                student.transferToNextCourse();
            }
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
