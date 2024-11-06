package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start"); //이 때 출력되는 main은 main method가 아니라 main Thread이다

        HelloThread helloThread = new HelloThread();

        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");

        helloThread.start();    //run이 아니라 start method를 호출해야 별도의 스레드에서 run() 코드가 실행된다.

        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");

        //결과는 그 때마다 약간의 차이가 존재함
    }
}