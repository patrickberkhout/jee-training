package local;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Assert;

public class CustomAssertions {
	
	public static void containsMessage(String m, Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String fullMessage = sw.toString();
		Assert.assertTrue("Expected that stacktrace should contain: " + m + ", actual :" + sw.toString(),
				fullMessage.contains(m));
	}

}
