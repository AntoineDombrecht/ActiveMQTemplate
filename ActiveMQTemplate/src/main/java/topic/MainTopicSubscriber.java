package topic;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTopicSubscriber implements Runnable{

	public void run() {
		
		try{
		
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");

			ATopicSubscriber subcriber = (ATopicSubscriber) applicationContext.getBean("topicSubscriber");
			
			Message m = subcriber.receive();
			System.out.println(m);
			System.out.println("message:"+((TextMessage) m).getText());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
