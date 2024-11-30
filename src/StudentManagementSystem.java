import java.sql.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private int currentId;

    public StudentManagementSystem(){
        students = new ArrayList<>();
        currentId = 1;
    }

    public void addStudent(String name,String email){
       /* Student newStudent = new Student(name,currentId,email);
        students.add(newStudent);
        System.out.println("Öğrenci başarıya eklendi.\n" + newStudent);
        currentId++; */

        String sql = "INSERT INTO Students (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();

            System.out.println("Öğrenci başarıyla veritabanına eklendi: " + name);
        } catch (SQLException e) {
            System.out.println("Öğrenci eklenirken hata oluştu: " + e.getMessage());
        }
    }

    public void listStudents(){
        /*if(students.isEmpty()){
            System.out.println("Kayıtlı öğrenci yok.");
        }else{
            for(Student x : students){
                System.out.println(x);
            }
        } */
        String sql = "SELECT * FROM Students";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Öğrenci listelenirken hata oluştu: " + e.getMessage());
        }
    }

    public void updateStudent(int id,String name,String email){
        /*for(Student x : students){
            if(x.getStudentId() == id){
                x.setName(name);
                x.setEmail(email);
                System.out.println("Öğrenci bilgileri güncellendi.");
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı."); */

        String sql = "UPDATE Students SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Öğrenci bilgileri güncellendi.");
            } else {
                System.out.println("Belirtilen ID ile öğrenci bulunamadı.");
            }
        } catch (SQLException e) {
            System.out.println("Öğrenci güncellenirken hata oluştu: " + e.getMessage());
        }

    }

    public void deleteStudent(int id){
        /*for(Student x : students){
            if(x.getStudentId()==id){
                students.remove(x);
                System.out.println("Öğrenci silindi.");
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı."); */
        String sql = "DELETE FROM Students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Öğrenci başarıyla silindi.");
            } else {
                System.out.println("Belirtilen ID ile öğrenci bulunamadı.");
            }
        } catch (SQLException e) {
            System.out.println("Öğrenci silinirken hata oluştu: " + e.getMessage());
        }

    }
}
