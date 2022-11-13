import java.util.ArrayList;

/**
 * Created by H on 07/11/2022.
 */
public class Grede {
    String code;
    String name;
    Teacher teacher;
    ArrayList<Student> students;

    public Grede(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    ///////////////////////////////////////////////
    public void addStuddent(Student student){
        this.students.add(student);
    }
    public void removeStuddent(Student student){
        this.students.remove(student);
    }




}
