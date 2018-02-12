package topic;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

public class ATopicSubscriber{
	
	private TopicConnectionFactory connectionFactory;
	
	private TopicSubscriber subscriber;
	private TopicSession session;
	
	public ATopicSubscriber(TopicConnectionFactory connectionFactory, Topic topic) throws Exception{
		super();
		this.connectionFactory = connectionFactory;
		TopicConnection connection = connectionFactory.createTopicConnection();
		session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		connection.start(); 

		subscriber = session.createSubscriber(topic);

	}
	
	public Message receive() throws JMSException {
		
		return subscriber.receive();
	
}	

}
