package Chapter2.thread;

 class TestSynchronizedStatic {

    static synchronized void display() {
        Thread t = Thread.currentThread();
        for (int i = 1; i <= 5; i++) {
            System.out.println(t.getName() + " : " + i);
        }
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            e.printStackTrace();
    }

}}
class StaticSynch extends Thread{
    TestSynchronizedStatic ex;
    StaticSynch(TestSynchronizedStatic ex){
        this.ex = ex;
    }
    public void run(){
        ex.display();
    }
}
public class SynchronizedStatic{
    public static void main(String[] args) {
        TestSynchronizedStatic ex = new TestSynchronizedStatic();
        StaticSynch t1 = new StaticSynch(ex);
        StaticSynch t2 = new StaticSynch(ex);
        t1.start();
        t2.start();
    }
}
