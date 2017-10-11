package local.gallery.view.model;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Model
public class ProducerFormModel {

	@Produces
	@Named
	DetailBean detail = new DetailBean();

	public DetailBean getDetail() {
		return detail;
	}

	public void setDetail(DetailBean detail) {
		this.detail = detail;
	}

}
