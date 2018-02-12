package app;
import queue.MySender;
import queue.MyReceiver;
import topic.MainTopicPublisher;
import topic.MainTopicSubscriber;

public class App {

	public static void thread(Runnable runnable, boolean daemon){
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}
	public static void main(String[] args) throws Exception {
		//queue	
		/*
		thread(new MySender(),false);   //one sender many receiver
		thread(new MyReceiver(),false);
		 */
		
		/*
		thread(new MySender(),false);							//many sender one receiver
		thread(new MySender(),false);
		thread(new MySender(),false);
		thread(new MyReceiver(),false);
		*/
		
		//Topic
		
		thread(new MainTopicSubscriber(),false);  //many subscriber one publisher
		thread(new MainTopicSubscriber(),false);
		thread(new MainTopicSubscriber(),false);
		thread(new MainTopicPublisher(),false);
		
		
		/*
		thread(new MainTopicSubscriber(),false); //one subscriber many publisher
		thread(new MainTopicPublisher(),false);
		thread(new MainTopicPublisher(),false);
		thread(new MainTopicPublisher(),false);
		*/
	}

}
