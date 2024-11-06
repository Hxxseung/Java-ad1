package thread.start;

public class BadThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start"); //이 때 출력되는 main은 main method가 아니라 main Thread이다

        HelloThread helloThread = new HelloThread();

        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");

        helloThread.run();    //run을 호출하게 되면 Thread를 생성하여 돌리는 것이 아니라 Main에서 돌아간다.

        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");

        //결과는 그 때마다 약간의 차이가 존재함
    }
}