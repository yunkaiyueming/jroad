package other;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

//用队列实现 多线程下的生产者，消费者的模型
public class BlockQueueDemo {

    public static void main(String[] args) {
        int BOUND = 10;
        int N_PRODUCERS = 4;
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        int poisonPill = Integer.MAX_VALUE;
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);

        //4个生产者
        for (int i = 1; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }

        //n个处理器数的消费者
        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }

        //new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer + mod)).start();
    }
}


//生产者模型
class NumbersProducer implements Runnable {
    private BlockingQueue<Integer> numbersQueue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    public NumbersProducer(BlockingQueue<Integer> numbersQueue, int poisonPill, int poisonPillPerProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    //向队列里塞
    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            int innum = ThreadLocalRandom.current().nextInt(100);
            System.out.println("入队列数据:"+innum);
            numbersQueue.put(innum);
        }
        for (int j = 0; j < poisonPillPerProducer; j++) {//入poisonPillPerProducer次
            numbersQueue.put(poisonPill);
        }
    }
}

//消费者模型
class NumbersConsumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                if (number.equals(poisonPill)) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "out result: " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " over");
        }
    }
}