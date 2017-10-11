package local.gallery.view.model;

import javax.enterprise.inject.Model;

@Model
public class FragmentFormModel {
	int val = 0;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
}
