package cn.lee.jason.thread.concurrent.demo.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jason on 17-3-29.
 */
public class DefaultThreadPool<T extends Runnable> implements ThreadPool<T> {

    private final static int MAX_WORKER = 10;
    private final static int MIN_WORKER = 1;
    private final static int DEFAULT_WORKER = 5;
    // 工作队列
    private LinkedList<T> jobs = new LinkedList<T>();
    // 工作者队列
    private List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workNum = DEFAULT_WORKER;

    private AtomicInteger threadNum = new AtomicInteger();
    public DefaultThreadPool() {
        initWorkers(DEFAULT_WORKER);
    }
    public DefaultThreadPool(int num) {
        workNum = num > MAX_WORKER?MAX_WORKER:num<MIN_WORKER?MIN_WORKER:num;
        initWorkers(workNum);
    }

    protected void initWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-Worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }

    public void execute(T job) {
        if(job != null){
            synchronized (job){
                jobs.addLast(job);
                job.run();
            }
        }
    }

    public void shutdown() {
        for(Worker worker : workers){
            worker.shutdown();
        }
    }

    public void addWorkers(int num) {
        synchronized (jobs){
            if(num+workNum > MAX_WORKER){
                num = MAX_WORKER-workNum;
            }
            initWorkers(num);
            this.workNum += num;
        }
    }

    public void removeWorkers(int num) {

    }

    public int getJobSize() {
        return jobs.size();
    }


    class Worker implements Runnable {

        private volatile boolean running = true;

        public void run() {
            while (running) {
                T job = null;
                synchronized (jobs) {
                    while(jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                            return ;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job !=null){
                    try{
                        job.run();
                    }catch(Exception e){

                    }
                }
            }
        }
        public void shutdown(){
            running = false;
        }
    }
}
