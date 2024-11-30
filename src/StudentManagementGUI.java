import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementGUI {
    private StudentManagementSystem sms = new StudentManagementSystem();

    public StudentManagementGUI() {
        JFrame frame = new JFrame("Öğrenci Yönetim Sistemi");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Öğrenci Yönetim Sistemi");
        titleLabel.setBounds(150, 10, 200, 30);
        frame.add(titleLabel);

        JButton addButton = new JButton("Öğrenci Ekle");
        addButton.setBounds(50, 50, 150, 30);
        frame.add(addButton);

        JButton listButton = new JButton("Öğrenci Listele");
        listButton.setBounds(50, 100, 150, 30);
        frame.add(listButton);

        JButton updateButton = new JButton("Öğrenci Güncelle");
        updateButton.setBounds(50, 150, 150, 30);
        frame.add(updateButton);

        JButton deleteButton = new JButton("Öğrenci Sil");
        deleteButton.setBounds(50, 200, 150, 30);
        frame.add(deleteButton);

        JButton exitButton = new JButton("Çıkış");
        exitButton.setBounds(50, 250, 150, 30);
        frame.add(exitButton);

        // Olay dinleyicileri
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Öğrenci adı:");
                String email = JOptionPane.showInputDialog("Öğrenci email:");
                sms.addStudent(name, email);
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sms.listStudents();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Güncellenecek öğrenci ID:"));
                String name = JOptionPane.showInputDialog("Yeni ad:");
                String email = JOptionPane.showInputDialog("Yeni email:");
                sms.updateStudent(id, name, email);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Silinecek öğrenci ID:"));
                sms.deleteStudent(id);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentManagementGUI();
    }
}