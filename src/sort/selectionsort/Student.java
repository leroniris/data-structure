package sort.selectionsort;

/**
 * @author Leron
 * @version 1.0.0
 * @create 2020/3/28 14:08
 */
public class Student implements Comparable<Student> {
    public Integer studentId;
    public String name;

    public Student(Integer studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        return this.studentId - s.studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}
