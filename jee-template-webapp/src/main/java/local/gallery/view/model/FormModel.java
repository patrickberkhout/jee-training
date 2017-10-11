package local.gallery.view.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;

@Model
public class FormModel {

	String stringAttribute;
	String singleCharacterAttribute;
	Integer integerAttribute;
	Date dateAttribute;
	String radioButtonAttribute;
	Boolean booleanAttribute;
	List<ListItem> listAttribute = new ArrayList<ListItem>(
			Arrays.asList(new ListItem("1", "one"), new ListItem("2", "two"), new ListItem("3", "three")));


	public List<ListItem> getListAttribute() {
		return listAttribute;
	}

	public void setListAttribute(List<ListItem> listAttribute) {
		this.listAttribute = listAttribute;
	}

	public Boolean getBooleanAttribute() {
		return booleanAttribute;
	}

	public void setBooleanAttribute(Boolean booleanAttribute) {
		this.booleanAttribute = booleanAttribute;
	}

	public String getRadioButtonAttribute() {
		return radioButtonAttribute;
	}

	public void setRadioButtonAttribute(String radioButtonAttribute) {
		this.radioButtonAttribute = radioButtonAttribute;
	}

	public String getSingleCharacterAttribute() {
		return singleCharacterAttribute;
	}

	public void setSingleCharacterAttribute(String singleCharacterAttribute) {
		this.singleCharacterAttribute = singleCharacterAttribute;
	}

	public String getStringAttribute() {
		return stringAttribute;
	}

	public void setStringAttribute(String stringAttribute) {
		this.stringAttribute = stringAttribute;
	}

	public Integer getIntegerAttribute() {
		return integerAttribute;
	}

	public void setIntegerAttribute(Integer integerAttribute) {
		this.integerAttribute = integerAttribute;
	}

	public Date getDateAttribute() {
		return dateAttribute;
	}

	public void setDateAttribute(Date dateAttribute) {
		this.dateAttribute = dateAttribute;
	}

	public String getDisplay() {
		return toString();
	}

	public String verifySingleCharacterAttribute() {

		if (singleCharacterAttribute != null && singleCharacterAttribute.length() > 1) {
			throw new IllegalArgumentException("Single character attribute can not have length > 1");
		}
		return "gallery";
	}

	@Override
	public String toString() {
		return "FormModel [stringAttribute=" + stringAttribute + ", singleCharacterAttribute="
				+ singleCharacterAttribute + ", integerAttribute=" + integerAttribute + ", dateAttribute="
				+ dateAttribute + "]";
	}

}
