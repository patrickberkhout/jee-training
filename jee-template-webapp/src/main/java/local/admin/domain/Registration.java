package local.admin.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
		@NamedQuery(name = "Registration.findByUsername", query = "SELECT r FROM Registration r WHERE r.username = :username") })
public class Registration {

	@Id
	@Column(name = "registration_id")
	String registrationId;

	@Size(min=5) @NotNull
	String username;
	String password;
	String nickname;
	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Role> roles = new ArrayList<Role>();

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getRole() {
		if (roles != null && roles.size() > 0) {
			return roles.get(0).getRole();
		}
		return "";
	}
}
