package creational.singleton;

public class Database4 {
    private static Database4 instance;

    private Database4() {
        System.out.println("Database object created...");
    }

    public static synchronized Database4 getInstance() {
        if (instance == null) {
            instance = new Database4();
            return instance;
        }
    }

}

public class threadsafeSingleton {

}

/*
 * What is a thread?
 * A thread is the smallest unit of execution within a process.
 * Multiple threads can execute tasks concurrently within the same application.
 * Imagine:
 * - Thread 1 wants a Database object.
 * - Thread 2 also wants a Database object.
 * - Both execute getInstance() simultaneously.
 * 
 * This situation is called a Race Condition: A race condition occurs when
 * multiple threads access shared data concurrently,
 * and the final result depends on the timing or order of their execution.
 * 
 * 
 * What is Thread-Safe Singleton?
 * Definition:
 * A Thread-Safe Singleton is an implementation of the Singleton Design Pattern
 * that ensures
 * only one instance of a class is created even when multiple threads access it
 * simultaneously.
 * 
 * Solution 1: Using the synchronized keyword
 * The synchronized keyword ensures that only one thread at a time can execute
 * the synchronized method using the same lock.
 * Because your method is static synchronized, Java uses the Database
 * class-level lock, also known as the class monitor.
 */
