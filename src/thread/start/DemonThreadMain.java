package thread.start;

public class DemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);   //데몬 스레드 여부
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run() start");
            try {
                Thread.sleep(10000); // 10초간 실행
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}


//결과 중에 daemonThread가 종료되지 않았음에도 다른 모든 스레드가 종료되자마자 끝나는 결과를 얻을 수 있음
//데몬 스레드 특징 : 모든 스레드가 종료되면 데몬 스레드가 종료되지 않더라도 종료된다.