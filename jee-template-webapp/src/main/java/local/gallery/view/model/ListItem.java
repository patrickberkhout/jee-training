package local.gallery.view.model;

public class ListItem {

	String id;
	String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ListItem() {
	}

	public ListItem(String id, String name) {
		this.name = name;
		this.id = id;
	}
}
