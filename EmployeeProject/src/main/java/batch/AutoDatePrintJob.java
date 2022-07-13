package batch;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AutoDatePrintJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//자동으로 일을 할 메서드
		//일을 끝날 때 까지 계속 일을 할것이다 라는 건 필요 없음 스케줄러가 알아서 해줌
		//simleDate쓸려면 필요해서 date 객체 만듦
		Date date = new Date(Calendar.getInstance().getTimeInMillis());	//오늘 날짜 세팅
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		
		//스레드 만들 때 워커 만드는 것과 같다. run 과 execute는 비슷.
	}

}
