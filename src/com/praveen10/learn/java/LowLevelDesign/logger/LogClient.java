package com.praveen10.learn.java.LowLevelDesign.logger;

public interface LogClient {

    // When a process starts, it calls 'start' with processId and startTime
    void start(String processId);

    // When a process ends, it calls 'end' with processId and endTime
    void end(String processId);

    /*
    *   Polls the first log entry of a completed process sorted by startTime of the processes
    *
    *
    */
    void poll();
}
