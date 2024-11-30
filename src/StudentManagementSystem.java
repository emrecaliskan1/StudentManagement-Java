import java.util.ArrayList;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private int currentId;

    public StudentManagementSystem(){
        students = new ArrayList<>();
        currentId = 1;
    }

    public void addStudent(String name,String email){
        Student newStudent = new Student(name,currentId,email);
        students.add(newStudent);
        System.out.println("Öğrenci başarıya eklendi.\n" + newStudent);
        currentId++;
    }

    public void listStudents(){
        if(students.isEmpty()){
            System.out.println("Kayıtlı öğrenci yok.");
        }else{
            for(Student x : students){
                System.out.println(x);
            }
        }
    }

    public void updateStudent(int id,String name,String email){
        for(Student x : students){
            if(x.getStudentId() == id){
                x.setName(name);
                x.setEmail(email);
                System.out.println("Öğrenci bilgileri güncellendi.");
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı.");

    }

    public void deleteStudent(int id){
        for(Student x : students){
            if(x.getStudentId()==id){
                students.remove(x);
                System.out.println("Öğrenci silindi.");
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı.");

    }
}
