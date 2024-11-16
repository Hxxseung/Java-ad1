package thread.controll.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class MyPrinterV3 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while(true){
            log("프린터할 문서를 입력하세요. 종료(q): ");
            String input = userInput.nextLine();
            if(input.equals("q")){
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>(); //여러 스레드가 같이 접근하는 Queue는 Concurrent가 붙은걸 써야함.

        @Override
        public void run() {
            while(!Thread.interrupted()){
                if (jobQueue.isEmpty()) {
                    continue;
                }
                try {
                    String job = jobQueue.poll();
                    log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                    Thread.sleep(3000); //출력에 걸리는 시간
                    log("출력 완료: " + job);
                } catch (InterruptedException e) {
                    log("인터럽트!");
                    break;
                }
            }
            log("프린터 종료");
        }
        public void addJob(String input){
            jobQueue.offer(input);
        }
    }
}
