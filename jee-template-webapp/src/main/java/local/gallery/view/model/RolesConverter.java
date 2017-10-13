package local.gallery.view.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("rolesConverter")
public class RolesConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String input) {
		List<String> result = new ArrayList<String>();
		if (input == null) {
			return result;
		}
		for (String role : input.replaceAll("\\w", "").split(",")) {
			result.add(role);
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
