package creational.singleton;
// why we need singleton

//public class
class Database {

    // public constructor
    public Database() {
        System.out.println(" Database object created");
    }
}

public class problem_understanding {
    public static void main(String[] args) {
        // Database db1 = new Database();
        // Database db2 = new Database();
        // Database db3 = new Database();
    }
}
/*
 * when we create multiple objcet all want to access database at a time ,
 * race condition occurs . so we will make sure there is only one object by
 * which we can call.
 */