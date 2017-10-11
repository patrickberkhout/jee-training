package local.view.model;

import javax.enterprise.inject.Model;

@Model
public class IndexModel {
	
	private String name = "index";

	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return "howdy";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
