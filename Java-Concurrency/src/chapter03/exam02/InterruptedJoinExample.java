package chapter03.exam02;

public class InterruptedJoinExample {

    public static void main(String[] args) {

        Thread longRunningThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("긴 작업 스레드가 계속 실행 중...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("긴 작업 스레드가 인터럽트 되었습니다.");
            }
        });

        longRunningThread.start();

        Thread thread = new Thread(() -> {
            try {
                System.out.println("인터럽트 스레드가 2초 후에 긴 작업 스레드를 인터럽트 합니다.");
                Thread.sleep(2000);

                longRunningThread.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();
    }
}
