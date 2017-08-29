package training.client;

import java.util.Hashtable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SimpleJMSClient {

	private static final String DEFAULT_USERNAME = "jmsuser";
	private static final String DEFAULT_PASSWORD = "Welkom01!";

	JMSContext contextObj = null;
	Queue exampleQueue = null;

	public void setup() throws Exception {

		String userName = System.getProperty("messaging.user", DEFAULT_USERNAME);
		String password = System.getProperty("messaging.password", DEFAULT_PASSWORD);
		Hashtable<Object, Object> environment = new Hashtable<>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		environment.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8181");
		InitialContext initialContext = new InitialContext(environment);

		System.out.println("USER:" + userName);
		System.out.println("PASSWORD:" + password);

		ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("jms/RemoteConnectionFactory");
		contextObj = cf.createContext(userName, password);
		exampleQueue = (Queue) initialContext.lookup("jms/exampleQueue");

		System.out.println("setup() JMS objects found on remote broker:\t" + contextObj + "\t" + exampleQueue);

	}

	public void sendJMSMessage() throws Exception {
		String content = "Example message";
		contextObj.createProducer().send(exampleQueue, content);
	}

	public void shutdown() throws Exception {
		if (contextObj != null)
			contextObj.close();
	}

	public static void main(String[] args) {
		SimpleJMSClient client = new SimpleJMSClient();
		try {
			client.setup();
			client.sendJMSMessage();
			client.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
