package footprints.disruptor.prodcons;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

public class Sample {

    public static void main(String[] args) {

        final long startTime = System.nanoTime();
        final EventHandler<Message> handler = new EventHandler<Message>() {
            // event will eventually be recycled by the Disruptor after it wraps
            public void onEvent(final Message event, final long sequence, final boolean endOfBatch) throws Exception {
                Integer value = event.getMsg();
                if (value % 10000 == 0) {
                    System.out.println(Thread.currentThread().getName() + " By Handler : ValueEvent: " + event +"-"+value+ " Sequence: " + sequence);
                    double timeINnanos = (System.nanoTime() - startTime);
                    double timetaken = (timeINnanos / 1e9);
                    System.out.println("Time Taken till now in sec " + timetaken);
                }
            }
        };
        final EventHandler<Message> handler2 = new EventHandler<Message>() {
            // event will eventually be recycled by the Disruptor after it wraps
            public void onEvent(final Message event, final long sequence, final boolean endOfBatch) throws Exception {
                Integer value = event.getMsg();
                if (value % 10000 == 0) {
                    System.out.println(Thread.currentThread().getName() + " By Handler2 : ValueEvent: " + event +"-"+value+ " Sequence: " + sequence);
                    double timeINnanos = (System.nanoTime() - startTime);
                    double timetaken = (timeINnanos / 1e9);
                    System.out.println("Time Taken till now in sec " + timetaken);
                }
            }
        };

        WorkHandler<Message> workHandler = new WorkHandler<Message>() {
            @Override
            public void onEvent(Message event) throws Exception {
                Integer value = event.getMsg();
                if (value % 10000 == 0) {
                    System.out.println(Thread.currentThread().getName() + " By Handler2 : ValueEvent: " + event +"-"+value);
                    double timeINnanos = (System.nanoTime() - startTime);
                    double timetaken = (timeINnanos / 1e9);
                    System.out.println("Time Taken till now in sec " + timetaken);
                }
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        // Preallocate RingBuffer with 1024 ValueEvents
        Disruptor<Message> disruptor = new Disruptor<Message>(Message.EVENT_FACTORY, 1 << 11, exec,
                ProducerType.MULTI, new BusySpinWaitStrategy());
        // make handler
        // register handler with disruptor
       // disruptor.handleEventsWith(handler,handler,handler,handler,handler);
        disruptor.handleEventsWithWorkerPool(workHandler, workHandler, workHandler);

        RingBuffer<Message> ringBuffer = disruptor.start();

        Producer producer = new Producer(ringBuffer);

        //starting producer to produce messages in queue
        Thread p = new Thread(producer);
        p.start();

//        Producer producer2 = new Producer(ringBuffer);
//
//        //starting producer to produce messages in queue
//        Thread p2 = new Thread(producer2);
//        p2.start();

        try {
            p.join();
//            p2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

