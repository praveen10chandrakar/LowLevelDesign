package com.praveen10.learn.java.LowLevelDesign.logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class LoggerImplementation implements LogClient{

    private final Map<String, Process> processes;
    private final TreeMap<Long, Process> queue;

    public LoggerImplementation(){
        this.queue = new TreeMap<>((startTime1, startTime2) -> (int)(startTime1 - startTime2));
        this.processes = new HashMap<>();
    }

    @Override
    public void start(String processId) {
        Long now = System.currentTimeMillis();
        final Process process = new Process(processId, now);
        processes.put(processId, process);
        queue.put(now, process);
    }

    @Override
    public void end(String processId) {
        final long now = System.currentTimeMillis();
        processes.get(processId).setEndTime(now);
    }

    @Override
    public void poll() {
        if (queue.isEmpty()){
            System.out.println("Queue is empty...");

            // wait for end
            return;
        }
        final Process process = queue.firstEntry().getValue();
        if(process.getEndTime() != -1){
            System.out.println(process.getId() + " started at " + process.getStartTime() +
                    " and ended at " + process.getEndTime() );
            processes.remove(process.getId());
            queue.pollFirstEntry();
        }

        // wait for the end of first process id
    }
}
