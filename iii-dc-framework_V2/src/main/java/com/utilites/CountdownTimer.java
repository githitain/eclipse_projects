package com.utilites;


import java.time.Duration;
import java.time.Instant;

import com.setting.TestSettings;


public class CountdownTimer 
{
    private Instant startTime;

    public static CountdownTimer startNewTimer() {
        CountdownTimer timer = new CountdownTimer();
        timer.start();

        return timer;
    }

    public void start() {
        startTime = Instant.now();
    }

    public boolean isTimeoutElapsed() {
        return isTimeoutElapsed(TestSettings.Current.getWaitElementTimeout());
    }

    public boolean isTimeoutElapsed(int timeoutSeconds) {
        return Duration.between(startTime, Instant.now()).toMillis() > timeoutSeconds * 1000;
    }
}
