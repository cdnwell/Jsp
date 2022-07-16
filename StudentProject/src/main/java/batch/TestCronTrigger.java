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
	//크론식 - 원하는 주기를 설정하는 문자열 ( 한 달 마다, 일주일 마다, 일 년 마다 ... )
	private String timer;
	//Job을 상속 받는 클래스 --> 실제 작업을 하는 클래스
	// <? extends Job> Job클래스를 상속 받는 애들만 받아오겠다.
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
	
	//스케줄러에 Job을 등록
	//현재 내가 가지고 있는 것을 등록을 해주겠다.
	public void triggerJob() {
		//scheduler 생성할 공장하나를 만듦
		SchedulerFactory factory = new StdSchedulerFactory();
		//작업 스케줄러를 넣었으니 해제할 것도 필요함.
		JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(job.getName(),"group").build();
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("triger","group")
				.withSchedule(CronScheduleBuilder.cronSchedule(timer)).build();
		//다 한 후 스케줄러를 만들어서 시작
		
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
