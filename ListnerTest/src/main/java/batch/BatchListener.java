package batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.SchedulerException;

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
    	try {
    		// trigger가 가지고 있는 scheduler를 clear하고 shutdown까지 함
    		System.out.println("배치프로그램 종료");
			trigger.scheduler.clear();
			trigger.scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("배치프로그램 실행");
//    	trigger = new TestCronTrigger("0/5 * * * * ?",AutoDatePrintJob.class);
//    	trigger.triggerJob();
    }
	
}
