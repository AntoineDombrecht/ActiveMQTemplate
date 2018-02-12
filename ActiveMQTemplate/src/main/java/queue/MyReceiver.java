package queue;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyReceiver implements Runnable {

	public void run() {
		try{
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			QueueReceiver receiver = session.createReceiver(queue);
			connection.start();
			/*Message m = receiver.receive();	
			if(m instanceof TextMessage){
				TextMessage message=(TextMessage) m;
				System.out.println("reading message:"+message.getText());
			}*/
			Message m=receiver.receive();
			System.out.println(m);
		//	System.out.println("message:"+((TextMessage) m).getText());
			
			session.close();
		    connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
