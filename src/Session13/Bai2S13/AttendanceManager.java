package Session13.Bai2S13;

import java.util.ArrayList;

public class AttendanceManager implements Manage<Student>{
ArrayList<Student> students = new ArrayList<Student>();


    @Override
    public void add(Student manageObj) {
        students.add(manageObj);
    }

    @Override
    public void update(int index, Student manageObj) {

        students.set(index, manageObj);
    }

    @Override
    public void delete(int index) {

        students.remove(index);
    }

    @Override
    public void display() {

        students.forEach(student -> System.out.println(student.toString()));

    }
}
