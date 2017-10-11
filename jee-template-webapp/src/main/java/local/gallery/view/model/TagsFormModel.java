package local.gallery.view.model;

import javax.enterprise.inject.Model;

@Model
public class TagsFormModel {

	String stringAttribute;
	String[] collectionAttribute = {"FIRST"};

	public String getStringAttribute() {
		return stringAttribute;
	}

	public void setStringAttribute(String stringAttribute) {
		this.stringAttribute = stringAttribute;
	}

	public String[] getCollectionAttribute() {
		return collectionAttribute;
	}

	public void setCollectionAttribute(String[] collectionAttribute) {
		this.collectionAttribute = collectionAttribute;
	}

	

}
