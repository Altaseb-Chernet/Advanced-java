package Chapter2.thread;

class AA extends Thread{
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println("hi");
        }
    }
}

class BB extends Thread{
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println("Hello");
        }
    }
}
public class threadExample {
public static void main(String[] args) {
    AA obj1=new AA();
    BB obj2=new BB();
    obj1.start();
    obj2.start();
}
    
}