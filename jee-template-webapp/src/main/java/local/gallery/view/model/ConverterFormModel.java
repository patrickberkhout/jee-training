package local.gallery.view.model;

import java.util.Calendar;
import java.util.Date;

import javax.enterprise.inject.Model;

@Model
public class ConverterFormModel {

	Integer integerField;
	Date dateField = Calendar.getInstance().getTime();
	String currencyField = "$1239.80";
	
	public String getCurrencyField() {
		return currencyField;
	}
	public void setCurrencyField(String currencyField) {
		this.currencyField = currencyField;
	}
	public Integer getIntegerField() {
		return integerField;
	}
	public void setIntegerField(Integer integerField) {
		this.integerField = integerField;
	}
	public Date getDateField() {
		return dateField;
	}
	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}
	
}
