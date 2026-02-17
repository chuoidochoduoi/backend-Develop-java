package Session13.Bai1S13;


public class User {
    String name;
    String email;
    String phoneNumber;

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public  void  print(){

        System.out.println(name+"-"+email+"-"+phoneNumber);
    }
}
