public class FinalExam {
    public static void main(String[] args) {
        Runnable print10 = new Runnable() {
            @Override
            public void run() {
                System.out.println(10);
            }
        };
        Runnable print20 = new Runnable() {
            @Override
            public void run() {
                System.out.println(20);
            }
        };
        Runnable print100 = new Runnable() {
            @Override
            public void run() {
                System.out.println(100);
            }
        };

        Thread thread1 = new Thread(print10);
        Thread thread2 = new Thread(print20);
        Thread thread3 = new Thread(print100);

        thread1.start();
        thread2.start();
    }
}