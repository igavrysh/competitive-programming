import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private static int NUMBER_OF_PHILS = 5;

    private Lock[] forks;

    public DiningPhilosophers() {
        forks = new Lock[NUMBER_OF_PHILS];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(
        int philosopher,
        Runnable pickLeftFork,
        Runnable pickRightFork,
        Runnable eat,
        Runnable putLeftFork,
        Runnable putRightFork
    ) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = philosopher == NUMBER_OF_PHILS-1 ? 0 : philosopher+1;
        if (leftFork < rightFork) {
            forks[leftFork].lock();
            forks[rightFork].lock();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
            forks[rightFork].unlock();
            forks[leftFork].unlock();
        } else {
            forks[rightFork].lock();
            forks[leftFork].lock();
            pickRightFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
            forks[leftFork].unlock();
            forks[rightFork].unlock();
        }
    }

    public static void main(String[] args) {
        int N = 100;
        Runnable[] pickedForks = new Runnable[NUMBER_OF_PHILS], putForks = new Runnable[NUMBER_OF_PHILS], eats = new Runnable[NUMBER_OF_PHILS];

        for (int i = 0; i < NUMBER_OF_PHILS; i++) {
            final int threadIdx = i;
            pickedForks[i] = () -> {
                System.out.println("fork " + threadIdx + " picked");
            };
            putForks[i] = () -> {
                System.out.println("fork " + threadIdx + " put down");
            };
            eats[i] = () -> {
                System.out.println("phi " + threadIdx + " started eating");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("phi " + threadIdx + " stopped eating");
            };
        }

        DiningPhilosophers process = new DiningPhilosophers();

        Thread[] threads = new Thread[NUMBER_OF_PHILS];
        for (int i = 0; i < threads.length; i++) {
            final int phi = i;
            final int leftI = i;
            final int rightI = i == NUMBER_OF_PHILS-1 ? 0 : i+1;
            threads[i] = new Thread(() -> {
                for (int iter = 0; iter < N; iter++) {
                    try {
                        process.wantsToEat(phi, pickedForks[leftI], pickedForks[rightI], eats[phi], putForks[leftI], putForks[rightI]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
} 