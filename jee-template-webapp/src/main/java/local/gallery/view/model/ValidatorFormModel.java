package local.gallery.view.model;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;

@Model
public class ValidatorFormModel {

	
	Long longField;
	
	@NotNull
	String stringField;
	
	
	
	public String getStringField() {
		return stringField;
	}


	public void setStringField(String stringField) {
		this.stringField = stringField;
	}


	public Long getLongField() {
		return longField;
	}


	public void setLongField(Long longField) {
		this.longField = longField;
	}


	public void validateNonZero(FacesContext context, UIComponent component,
			Object componentValue) {
		if (componentValue != null && ((Long) componentValue) != 0L)
			return;

		UIInput inputComponent = (UIInput) component;
		inputComponent.setValid(false);
		context.addMessage(component.getClientId(context), new FacesMessage(
				"This number cannot be zero"));
		
		// Add another using the faces context... without id in this case..
		FacesContext.getCurrentInstance().addMessage(null, 
			    new FacesMessage("my summary error text", "my detail error text"));
	}
}
