import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("1-Öğrenci Ekle");
            System.out.println("2-Öğrenci Listele");
            System.out.println("3-Öğrenci Güncelle");
            System.out.println("4-Öğrenci Sil");
            System.out.println("5-Çıkış");
            System.out.print("\nSeçiminiz: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1 :
                    System.out.print("Öğrenci adı: ");
                    String name = input.nextLine();
                    System.out.print("Öğrenci mail: ");
                    String email = input.nextLine();
                    sms.addStudent(name,email);
                    break;

                case 2:
                    sms.listStudents();
                    break;

                case 3:
                    System.out.print("Güncellenecek öğrenci id: ");
                    int updateId = input.nextInt();
                    input.nextLine();
                    System.out.print("Güncellenecek ad: ");
                    String newName = input.nextLine();
                    System.out.print("Yeni email: ");
                    String newEmail = input.nextLine();
                    sms.updateStudent(updateId,newName,newEmail);
                    break;

                case 4:
                    System.out.print("Silinecek öğrenci id'si: ");
                    int deleteStudent = input.nextInt();
                    sms.deleteStudent(deleteStudent);
                    break;

                case 5:
                    System.out.println("Çıkış yapılıyor.");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Tekrar seçim yapınız:");

            }

        }




    }

}