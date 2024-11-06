package thread.start.test;

import static util.MyLogger.log;

public class StartTest1Main extends Thread {
    public static void main(String[] args) {
        CounterThread thread = new CounterThread();
        thread.start();
    }

    static class CounterThread extends Thread{
        @Override
        public void run(){
            for(int i = 0; i < 5; i++){
                log("value : " + i);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}