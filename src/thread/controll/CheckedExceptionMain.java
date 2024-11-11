package thread.controll;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {
        @Override
        public void run() /*throws Exception*/{ //주석 풀면 예외 발생
            //throw new Exception();    //주석 풀면 예외 발생
        }
    }
}


//Runnable에는 run만 구성되어 있음
//부모가 체크
//예외처리를 안하면 자식도 체크 예외를 던질 수 없음
//부모의 체크예외보다 하위만 자식이 처리할 수 있다.