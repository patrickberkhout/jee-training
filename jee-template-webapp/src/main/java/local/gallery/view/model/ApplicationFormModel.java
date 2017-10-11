package local.gallery.view.model;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ApplicationFormModel implements Serializable {

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
