import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by students on 06/11/22.
 */
public class GUI {
    SchoolServices c;
    private JPanel mainPanel;
    private JButton addButton;
    private JButton viewButton;
    private JButton searchButton;
    private JButton saveButton;
    private JPanel allCards;
    private JPanel c1;
    private JPanel c2;
    private JPanel c3;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JButton addStudentButton;
    private JTextArea textArea1;
    private JTextField textField5;
    private JButton searchStudentButton;
    private JTextArea textArea2;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;

    public GUI() {
        c= new SchoolServices();
        c.readPersonFile();
        textArea1.setText(fillAll());
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c1);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c2);
                allCards.repaint();
                allCards.revalidate();
                fillAll();

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c3);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id=Integer.parseInt(t1.getText());
                String firstName=t2.getText();
                String lastName=t3.getText();
                String phoneNumber=t4.getText();
                int registrationYear=Integer.parseInt(t5.getText());
                int age=Integer.parseInt(t6.getText());
                String guardianis=t7.getText();
              boolean added =  c.addPerson(id,firstName, lastName, phoneNumber,registrationYear, age,guardianis);
                if (added)
                {
                    JOptionPane.showMessageDialog(null,"Added data");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    textArea1.setText(fillAll());


                }
                else
                    JOptionPane.showMessageDialog(null,"Somr thing went Wrong");


            }
        });
        searchStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i= Integer.parseInt(textField5.getText());
                Person x=c.searchForPerson(i);
                if (x!=null)
                    textArea2.setText(x.toString());
                else textArea2.setText("not found");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean saved= c.writePerson();
                if (saved)
                    JOptionPane.showMessageDialog(null,"Saved data");

            }
        });
    }
    public String fillAll()
    {
        allCards.removeAll();
        allCards.add(c2);
        allCards.repaint();
        allCards.revalidate();
        String s="ID Name Year Annual Salary\n";
        ArrayList<Person> all= c.getAll();
        for (Person x:all) {
            if (x!=null)
                s=s+x+"\n";

        }
        textArea1.setText(s);
        return s;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setSize(700,600);
        frame.setLocation(400,100);
        frame.setVisible(true);
    }
}
