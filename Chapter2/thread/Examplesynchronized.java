package Chapter2.thread;

public class Examplesynchronized {
    synchronized void display(){
        Thread t = Thread.currentThread();
        for(int i =1; i<5; i++){
            System.out.println(t.getName()+" : "+i);
        }
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            e.printStackTrace();
    }
    
}}
class T extends Thread{
    Examplesynchronized ex;
    T(Examplesynchronized ex){
        this.ex = ex;
    }
    public void run(){
        ex.display();
    }

}
class TestSynchronized {
    public static void main(String[] args) {
        Examplesynchronized ex = new Examplesynchronized();
        T t1 = new T(ex);
        T t2 = new T(ex);
        t1.start();
        t2.start();
    }
}

