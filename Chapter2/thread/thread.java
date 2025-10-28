package Chapter2.thread;
class A{
    public void show(){
        for(int i=0;i<10;i++){
            System.out.println("hi");
        }
    }
    

}
class B{
    public void show(){
    for(int i=0;i<10;i++){
            System.out.println("Hello");
        }
    }

}

public class thread {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        a.show();
        b.show();
    }
}