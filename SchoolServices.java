import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by H on 08/11/2022.
 */
public class SchoolServices {
    private ArrayList<Person> all;


    public SchoolServices() {
        all=new ArrayList<>();

    }


    public boolean addPerson(int id, String firstName, String lastName, String phoneNumber,int registrationYear,int age,String guardianis){
        Person e=new Student( id,firstName, lastName, phoneNumber,registrationYear, age,guardianis);
        all.add(e);
        return true;
    }
    public boolean addPerson(int id, String firstName, String lastName, String phoneNumber, float salary,int age,String guardianis){
        Person e=new Teacher( id,firstName, lastName, phoneNumber,salary, age,guardianis);
        all.add(e);
        return true;
    }

    public ArrayList<Person>getAll()
    {
        return all;
    }

    //////////////////////////////////////////////////////
    public  Person searchForPerson(int id)
    {
        boolean found=false;
        int i=0;
        while (!found&&i<all.size())
        {
            if (all.get(i)!=null) {
                if (all.get(i).getId() == id)
                    found = true;
                else i++;
            }
            else i++;
        }
        if (i<all.size())
            return all.get(i);
        else return null;
    }
    ////////////////////readPersonFile////////////////////////////
    public void readPersonFile()
    {
        try {
            Scanner in= new Scanner(new File("F:\\Person.txt"));
            while (in.hasNext())
            {
                int id=in.nextInt();
                String firstName=in.next();
                String lastName=in.next();
                String phoneNumber=in.next();
                int registrationYear=in.nextInt();
                int age=in.nextInt();
                String guardianis=in.next();
                addPerson(id,firstName,lastName,phoneNumber,registrationYear,age,guardianis);
            }
            in.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error in reading file "+e.getMessage());        }
    }
    ///////////////////////////writePerson////////////////////////////////
    public boolean writePerson()
    {
        try{
            PrintWriter writer= new PrintWriter(new File("F:\\Person.txt"));

            for (Person x:all) {
                writer.write(x.getId()+"    "+x.getFirstName()+"  "+x.getLastName()+x.getPhoneNumber()+"  "+((Student) x).getRegistrationYear()+x.getAge()+((Student) x).getGuardianis()+"\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }


}
