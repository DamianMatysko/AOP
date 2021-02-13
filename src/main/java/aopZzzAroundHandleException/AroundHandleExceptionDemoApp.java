package aopZzzAroundHandleException;

import aopZzzAroundHandleException.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundHandleExceptionDemoApp {
    private static Logger logger=Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain program: AroundDemoApp");
        logger.info("Calling getFortune()");
        boolean tripWire=true;
        String data = trafficFortuneService.getFortune(tripWire);
        logger.info("My fortune is: " + data);
        logger.info("Finished");

        context.close();
    }
}
