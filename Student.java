/**
 * Created by H on 08/11/2022.
 */
public class Student extends Person {
    static int counter = 0;
    int registrationYear;
    String guardianis;

    public Student(int id, String firstName, String lastName, String phoneNumber,int registrationYear,int age,String guardianis) {
        super(id, firstName, lastName, phoneNumber,age);
        this.registrationYear=registrationYear;
        this.guardianis=guardianis;
    }

    public String getGuardianis() {
        return guardianis;
    }

    public void setGuardianis(String guardianis) {
        this.guardianis = guardianis;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Student.counter = counter;
    }

    public Student(){
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }

    @Override
    public String toString() {
        return super.toString()+ "Student{" +
                "registrationYear=" + registrationYear +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return registrationYear == student.registrationYear;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + registrationYear;
        return result;
    }
}
