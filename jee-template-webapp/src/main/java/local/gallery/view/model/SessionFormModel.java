package local.gallery.view.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionFormModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Integer integerAttribute = 1;

	public Integer getIntegerAttribute() {
		return integerAttribute;
	}

	public void setIntegerAttribute(Integer integerAttribute) {
		this.integerAttribute = integerAttribute;
	}
	
	public void increaseByOne(){
		integerAttribute++;
		return;
	}
}
