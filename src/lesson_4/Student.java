package lesson_4;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int course;
    private final Map<String, Integer> marks = new HashMap<>();

    public Student(String name, String group, int course){
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public void transferToNextCourse() {
        if (course < 5) course++;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
