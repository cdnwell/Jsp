package batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;

/**
 * Application Lifecycle Listener implementation class BatchListener
 *
 */
@WebListener
public class BatchListener implements ServletContextListener {
	private TestCronTrigger trigger;
	
    /**
     * Default constructor. 
     */
    public BatchListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
//    	try {
//    		System.out.println("배치프로그램 종료");
//			trigger.scheduler.clear();
//			trigger.scheduler.shutdown();
//		} catch (SchedulerException e) {
//			e.printStackTrace();
//		}
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
//    	System.out.println("배치프로그램 실행");
//    	trigger = new TestCronTrigger("0 0 0/1 1/1 * ? *", AutoDatePrintJob.class);
//    	trigger.triggerJob();
    
    }
	
}
