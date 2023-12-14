/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prac12;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


/**
 *
 * @author USER
 */

public class UserRegistration extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField id;
    private JTextField email;
    private JTextField phone;
    private JButton btnNewButton;
    private JButton btnShowAll; 
    private JTextArea textArea; 

    public UserRegistration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1100, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Nuevo alumno");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Nombre");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Boleta");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmail = new JLabel("Correo Electrónico");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmail.setBounds(58, 324, 200, 29);
        contentPane.add(lblEmail);

        JLabel lblPhone = new JLabel("Teléfono");
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPhone.setBounds(58, 415, 200, 29);
        contentPane.add(lblPhone);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        id = new JTextField();
        id.setFont(new Font("Tahoma", Font.PLAIN, 32));
        id.setBounds(214, 235, 228, 50);
        contentPane.add(id);
        id.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 316, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        phone = new JTextField();
        phone.setFont(new Font("Tahoma", Font.PLAIN, 32));
        phone.setBounds(214, 407, 228, 50);
        contentPane.add(phone);
        phone.setColumns(10);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                int IDstudent = Integer.parseInt(id.getText());
                String userEmail = email.getText();
                long userPhone = Long.parseLong(phone.getText());

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");

                    String query = "INSERT INTO students VALUES('" + IDstudent + "','" + firstName + "')";
                    String query2 = "INSERT INTO students2 VALUES('" + IDstudent + "','" + userEmail + "','" + userPhone + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    int y = sta.executeUpdate(query2);
                    if (x == 0 && y == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is already exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "¡Bienvenido!, " + firstName + " Has sido registrado ");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 497, 259, 74);
        contentPane.add(btnNewButton);

        btnShowAll = new JButton("Mostrar Todos");
        btnShowAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTodosLosEstudiantes();
            }
        });
        btnShowAll.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnShowAll.setBounds(150, 497, 259, 74);
        contentPane.add(btnShowAll);

        textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textArea.setBounds(700, 151, 370, 400);
        contentPane.add(textArea);
    }

    private void mostrarTodosLosEstudiantes() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");

            String query1 = "SELECT * FROM school.students";
            String query2 = "SELECT * FROM school.students2";

            Statement sta1 = connection.createStatement();
            Statement sta2 = connection.createStatement();

            ResultSet rs1 = sta1.executeQuery(query1);
            ResultSet rs2 = sta2.executeQuery(query2);

            textArea.setText("");

            while (rs1.next() && rs2.next()) {
                int boleta = rs1.getInt("boleta");
                String name = rs1.getString("nombre");
                String email = rs2.getString("email");
                long phone = rs2.getLong("phone");

                textArea.append("Boleta: " + boleta + "\nNombre: " + name + "\nEmail: " + email + "\nTelefono: " + phone + "\n\n");
            }

            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
