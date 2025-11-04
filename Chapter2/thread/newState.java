package Chapter2.thread;

public class newState {
 
    public static void main(String[] args) {
        Thread t = new Thread();
        // t.start();
        System.out.println("current thread "+t.getState());
    }
}
