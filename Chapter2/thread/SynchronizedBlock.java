package Chapter2.thread;


public class SynchronizedBlock {
    void display(){
        synchronized(this){
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
}
}}
class BlockSync extends Thread{
    SynchronizedBlock ex;
    BlockSync(SynchronizedBlock ex){
        this.ex = ex;
    }
    public void run(){
        ex.display();
    }

}
class TestSynchronized {
    public static void main(String[] args) {
        SynchronizedBlock ex = new SynchronizedBlock();
        BlockSync t1 = new BlockSync(ex);
        BlockSync t2 = new BlockSync(ex);
        t1.start();
        t2.start();
    }
}

