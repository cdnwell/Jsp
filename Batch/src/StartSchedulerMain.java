
public class StartSchedulerMain {

	public static void main(String[] args) {
		//크론식
		TestCronTrigger trigger = new TestCronTrigger("0 0/1 * * 1/1 ? *",AutoDatePrintJob.class);
		trigger.triggerJob();
		
	}

}
