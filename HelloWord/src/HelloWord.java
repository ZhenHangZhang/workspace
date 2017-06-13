import java.sql.Date;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.Interface.Animal;
import com.Interface.Cat;
import com.PostRepository.Post;
import com.customLog.BlogAppException;
import com.ezparking.Car;
import com.ezparking.Printer;
import com.ezparking.Triple;

public class HelloWord {

	
	Byte byte1 = 1;
	
	
	
	public static void main(String[] args) {
 
		System.out.println("这是第一个项目");

		Post myPost = new Post();
		myPost.title = "1111111";
		myPost.content = "tiaomaying";
		myPost.print();

		System.out.println(Post.count);
		
		Post myPost1 = new Post();
		myPost1.title = "1111111";
		myPost1.content = "tiaomaying";
		myPost1.print();
		System.out.println(Post.count);

		Post myPost2 = new Post();
		myPost2.title = "1111111";
		myPost2.content = "tiaomaying";
		myPost2.print();
		System.out.println(Post.count);

		
		Post myPost3 = new Post();
		myPost3.title = "1111111";
		myPost3.content = "tiaomaying";
		myPost3.print();
		System.out.println(Post.count);

		
		
		
		Car car = new Car(0, "aotu");	
		car.color = 1;
		car.startUp();

		int sum = 0 , i = 0;
		
	while (i<= 100) {
		sum +=i;
		i++;
		System.out.println(sum);
	}
	do {
		sum +=i;
		i++;
		System.out.println(sum);
	} while (i<=200);	
		
	sum = 0;
	for (int j = 0; j < 100; j++) {
		
		sum +=j;
		System.out.println(sum);
		
		
	}
	
	String[] sentences = {"hello", "thank u", "thank u very much"};
	for (int index = 0; index < sentences.length; index++) {
	    System.out.println(sentences[index]);
	}	
		for (String sentence : sentences) {
		    System.out.println(sentence);

		}
		
		String testStr = "zhang hang zhen";
		System.out.println(testStr.length());
		System.out.println(testStr.charAt(11));
		System.out.println(testStr.trim());
		System.out.println(testStr.replace("z", "Z"));
		
		
		System.out.println(testStr.substring(5, testStr.length()));
		
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		sb.append("123");
		System.out.println(sb);

		sb.append("xyz");
		System.out.println(sb);

		System.out.println(sb.toString());
		sb.reverse();
		System.out.println(sb);
		
		
		Clock clock = Clock.systemDefaultZone();
		long mills = clock.millis();
		System.out.println(mills);

		Instant ins = clock.instant();
		System.out.println(ins);

		java.util.Date legacyDate =   Date.from(ins);
		
		System.out.println(legacyDate);
		
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());
		
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
		
		System.out.println(hoursBetween);
		
		System.out.println(minutesBetween);

		Triple<String, Integer, Float> triple = new Triple<String, Integer, Float>();
		triple.setA("something");
		triple.setB(1);
		triple.setC(1.0f);
	
		System.out.println(triple.getA());
		
		System.out.println(triple.getB());
		System.out.println(triple.getC());
		
		
		
        Integer[] intArray = { 1, 2, 3, 4, 5 };  
        Character[] charArray = { 'T', 'I', 'A', 'N', 'M', 'A', 'Y', 'I', 'N', 'G' };
        Printer.printArray(intArray);
        Printer.printArray(charArray);
// 
 
       try {
		int x= 5/0;
		System.out.println(x);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
       System.out.println("program is still running here!"); 
       
       
       
     
       
       try {
		func();
		
		bar();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
      
       
       System.out.println("program is still running here!"); 

  
        
    

	}
	
	private static void bar() throws BlogAppException {
		
		 System.out.println("let's assume BlogAppException happened when executing `create` command");
	        // 为了演示，这里我们假设执行create命令时，抛出了异常
	        throw new BlogAppException("create");
		
		
	}
	
	
	
	private static void func() throws Exception {
		int x= 5/0;
		System.out.println(x);
	}
	
	

}