public class Student {
    private String name;
    private int studentId;
    private String email;


    public Student(String name,int id, String email) {
        this.name=name;
        this.studentId = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Student {" +
                "id= " + studentId + ' ' +
                "name= " + name + ' ' +
                "email= " + email + '}';
    }
}