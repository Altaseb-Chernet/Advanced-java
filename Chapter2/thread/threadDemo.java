package Chapter2.thread;

class Hi extends Thread {
    public void run() {
    for (int i=0; i<5; i++) {
    System.out.println("Hi");
    try{
        Thread.sleep(10);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
 
 }}}

 class Hello extends Thread{
    public void run(){
        for(int i=0; i<=10; i++){
            System.out.println("hello");
            try{
        Thread.sleep(10);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
        }
    }
 }
 public class threadDemo {
    public static void main(String[] args) {
    Hi objhHi =new Hi();
    Hello objHello = new Hello();
    objhHi.setPriority(Thread.MAX_PRIORITY);
    objHello.setPriority(Thread.MAX_PRIORITY);
    
    System.out.println("Priority of hi thread: "+objhHi.getPriority());
    System.out.println("Priority of hello thread: "+objHello.getPriority());

    objhHi.start();
    try{
        objhHi.sleep(2);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    
    objHello.start();
    }}