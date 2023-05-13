package com.codeinspring.SpringScheduler.jobs;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class PricingEngine {

    static final Logger LOGGER = Logger.getLogger(PricingEngine.class.getName());
    private Double price;

    public Double getProductPrice() {
        return price;
    }

    // @Scheduled(fixedDelayString = "${interval}")
    // @SchedulerLock(name = "scheduledTaskName")
     @Scheduled(cron = "${interval-in-cron}")
     @SchedulerLock(name = "scheduledTaskName")
    public void computePrice() throws InterruptedException {
         Random random = new Random();
         price = random.nextDouble()*100;
         LOGGER.info("computing price at " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

         // added sleep to simulate method
         // which takes longer to execute.
         Thread.sleep(4000);
    }

    @Scheduled(initialDelay = 2000, fixedDelay = 3000)
    @Async
    public void refreshPricingParameters() {

        // update pricing parameters
        Random random = new Random();
        price = random.nextDouble() * 100;
        LOGGER.info("computing price at " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }
}

