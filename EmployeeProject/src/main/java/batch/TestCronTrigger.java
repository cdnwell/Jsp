package batch;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TestCronTrigger {
	private String timer;
	private Class<? extends Job> job;
	//Job을 등록할 스케줄러
	//스케줄러는 만들면 됨, 상속을 받는 job클래스랑 ... 만 받으면됨
	Scheduler scheduler;
	//import한 것 모두 quartz에 있다.
	public TestCronTrigger(String timer, Class<? extends Job> job) {
		super();
		this.timer = timer;
		this.job = job;
	}
	
	public void triggerJob() {
		SchedulerFactory factory = new StdSchedulerFactory();
		JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(job.getName(),"group").build();
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger","group")
				.withSchedule(CronScheduleBuilder.cronSchedule(timer)).build();
		
		try {
			scheduler = factory.getScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		//나머지 일하나 만들고 ,실행할 메인 클래스 만들면 끝, 북붙해서 쓰기
		
	}
	
}
