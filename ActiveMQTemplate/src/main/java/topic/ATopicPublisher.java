package topic;


	import javax.jms.JMSException;
	import javax.jms.QueueConnection;
	import javax.jms.Session;
	import javax.jms.TextMessage;
	import javax.jms.Topic;
	import javax.jms.TopicConnection;
	import javax.jms.TopicConnectionFactory;
	import javax.jms.TopicPublisher;
	import javax.jms.TopicSession;

	import org.fusesource.mqtt.cli.Publisher;

	public class ATopicPublisher{
		
		private TopicConnectionFactory connectionFactory;
		
		private TopicPublisher publisher;
		private TopicSession session;

		public ATopicPublisher(TopicConnectionFactory connectionFactory, Topic topic) throws Exception{
			super();
			this.connectionFactory = connectionFactory;
			TopicConnection connection = connectionFactory.createTopicConnection();
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

			publisher = session.createPublisher(topic);
			
			
		}

		public void publishMessage(String message) throws JMSException {
			TextMessage m = session.createTextMessage(message);
			publisher.publish(m);
		}
		

	}

