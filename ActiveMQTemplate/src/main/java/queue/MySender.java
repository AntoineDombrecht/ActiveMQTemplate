package queue;

import javax.jms.DeliveryMode;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySender implements Runnable {

	public void run() {
		
		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			Queue queue = (Queue) applicationContext.getBean("queue");
			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			TextMessage message = session.createTextMessage("HELLO sir ");
			QueueSender sender = session.createSender(queue);
		//	sender.send(message);
		//	sender.send(message, DeliveryMode.PERSISTENT, 1, 2000000);
			sender.send(message,DeliveryMode.NON_PERSISTENT,1,2000000);
		  //  System.out.println("message has been send!");
		    session.close();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}



	}

}
