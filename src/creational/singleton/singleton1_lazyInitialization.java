package creational.singleton;

class Database1 {

    // 1. Static instance variable
    private static Database1 instance; // database is the data type .

    // 2. Private constructor

    private Database1() {
        System.out.println("Database objcet created successfully ...");
    }

    // 3. public static method

    public static Database1 getInastance() {

        if (instance == null) {
            instance = new Database1(); // if database hadnt created yet (means null) so create a database..
        }

        return instance; // the return created database as instances
    }

    public void connect() {
        System.out.println("Connected to database...");
    }
}

public class singleton1_lazyInitialization {

    public static void main(String[] args) {
        Database1 db1 = Database1.getInastance(); /*
                                                   * Important : Static method is a method that belongs to the class
                                                   * itself and
                                                   * you can invoke a static method without creating objcet
                                                   */

        Database1 db2 = Database1.getInastance();

        Database1 db3 = Database1.getInastance();

        db1.connect();
        db2.connect();
        db3.connect();
    }

}

/*
 * $How to implement singleton in java..
 * 
 * Step 1: Make the constructor private : Because a private constructor prevents
 * us
 * from creating objects using new outside the class.
 * 
 * Step 2: Create a static instance variable : private static Database instance;
 * Why ? --> Because we want one shared variable belonging to the class, rather
 * than separate variables for each object.
 * 
 * Step 3: Create a public static method : Why ? -->Because we want one shared
 * variable belonging to the class,
 * rather than separate variables for each object.
 * 
 * code :
 * public static Database getInstance() { //
 * 
 * if (instance == null) {
 * instance = new Database();
 * }
 * 
 * return instance;
 * }
 * 
 * What happens here?
 * - First call: instance == null, so a new object is created.
 * - Second call: An object already exists, so no new object is created.
 * - Third call: The existing object is returned again.
 * 
 */