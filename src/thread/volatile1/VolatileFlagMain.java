package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new  MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {
        //boolean runFlag = true;   //변경을 감지는 하지만 변경된 사항이 적용되는 시점은 어떻게 될지 모름 => while문을 탈출하지 않음.
        volatile boolean runFlag = true; //캐시메모리를 포기하고 메인 메모리에 직접 접근함. / 단점 : 성능저하

        @Override
        public void run(){
            log("task 시작");
            while(runFlag){
                //  runFlag가 false로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
