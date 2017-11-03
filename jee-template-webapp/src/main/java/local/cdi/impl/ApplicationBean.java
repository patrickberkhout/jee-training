package local.cdi.impl;

import javax.inject.Singleton;

@Singleton
public class ApplicationBean {

		public String hello(){
			return "Hello";
		}
}
