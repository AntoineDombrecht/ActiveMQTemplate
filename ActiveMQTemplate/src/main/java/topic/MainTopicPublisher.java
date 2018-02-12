package topic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTopicPublisher implements Runnable{

	public void run() {

		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");

			ATopicPublisher publisher = (ATopicPublisher) applicationContext.getBean("topicPublisher");
			
			publisher.publishMessage("Hello from topic");
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
