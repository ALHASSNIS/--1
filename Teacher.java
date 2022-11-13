/**
 * Created by H on 08/11/2022.
 */
public class Teacher extends Person {
    float salary;
    String guardianis;

    public Teacher(int id, String firstName, String lastName, String phoneNumber, float salary,int age,String guardianis) {
        super(id, firstName, lastName, phoneNumber,age);
        this.salary = salary;
        this.guardianis=guardianis;
    }

    public Teacher() {
    }

    public float getSalary() {
        return salary;
    }

    public String getGuardianis() {
        return guardianis;
    }

    public void setGuardianis(String guardianis) {
        this.guardianis = guardianis;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+"Teacher{" +
                "salary=" + salary +
                ", guardianis='" + guardianis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Teacher teacher = (Teacher) o;

        if (Float.compare(teacher.salary, salary) != 0) return false;
        return guardianis != null ? guardianis.equals(teacher.guardianis) : teacher.guardianis == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (salary != +0.0f ? Float.floatToIntBits(salary) : 0);
        result = 31 * result + (guardianis != null ? guardianis.hashCode() : 0);
        return result;
    }
}
