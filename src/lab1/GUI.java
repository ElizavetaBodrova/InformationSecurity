package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    JButton b1, b2,b3;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    String a;
    eHandler handler = new eHandler();


    public GUI(String s) {
        super(s);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());
        b1=new JButton ("Зашифровать");
        b2=new JButton ("Расшифровать");
        b3=new JButton("Очистить");
        l1=new JLabel ("Исходный текст:");
        l2=new JLabel("Ключ:");
        l3=new JLabel ("");
        l4=new JLabel("");
        t1=new JTextField (10);
        t2=new JTextField (10);

        add(l1);
        add(l4);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(b1);
        add(b2);
        add(b3);
        b2.addActionListener(handler);
        b1.addActionListener(handler);
        b3.addActionListener(handler);


    }

    public class eHandler implements ActionListener {
    Algorithm algorithm=new Algorithm();
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==b1){
                    algorithm.SetKey(t2.getText());
                    String result=algorithm.Encrypt(t1.getText());
                    a = "Результат: " + result;
                    l3.setText(a);


                }
                if (e.getSource()==b2){
                    algorithm.SetKey(t2.getText());
                    String result=algorithm.Decrypt(t1.getText());
                    a = "Результат: " + result;
                    l3.setText(a);

                }
                if(e.getSource()==b3){
                    t1.setText(null);
                    t2.setText(null);
                    l3.setText("");
                }


            }catch (Exception ex){JOptionPane.showMessageDialog(null, "Введите текст и ключ.");}

        }

    }
}
class Main {

    public static void main(String[] args) {
        GUI r = new GUI("Задание №1");
        r.setVisible (true);
        r.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        r.setSize(250, 200);

    }


}
