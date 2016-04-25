package sky.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestTimeStamp {
	public static void main(String[] args) {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.set(2016, 7, 19);
		Date d2 = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(d) + " 00:00:00";
		String endStr = sdf.format(d2) + " 23:59:59";
		Timestamp t = new Timestamp(System.currentTimeMillis());
		Timestamp t2 = new Timestamp(System.currentTimeMillis());
		t = Timestamp.valueOf(str);
		t2 = Timestamp.valueOf(endStr);
		System.out.println(t2);
		
	}
}
