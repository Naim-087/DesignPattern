package prerequisities.OOP.inheritence;

class User {
    String username;
    String email;

    User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    void displayProfile() {
        System.out.println("Username : " + username);
        System.out.println("Email : " + email);
    }
}

class AdminUser extends User {

    String name;
    double salary;

    AdminUser(String username, String email, String name, double salary) {

        super(username, email);

        this.name = name;
        this.email = email;
    }

    public void manageUsers() {

        System.out.println("Managing users....");
    }
}

class employee extends User {

    String name;
    double salary;

    employee(String username, String email, String name, double salary) {

        super(username, email);

        this.name = name;
        this.salary = salary;

    }

    void work() {
        System.out.println("Working on data engineering....");
    }
}

public class hierarchical_inheritence_01 {
    public static void main(String[] args) {
        AdminUser admin = new AdminUser("xyz_123", "ayz@gmail.com", "Salaf", 40000);

        employee emp1 = new employee("abc@", "employee@gmail.com", "Ahmed", 60000);

        admin.displayProfile();
        admin.manageUsers();

        emp1.displayProfile();
        emp1.work();
    }
}
