package cl.talentoDigital.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@SequenceGenerator(name="SQ_USUARIO", initialValue=1, allocationSize=1)
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_USUARIO")
	private Long id;
	private String userName;
	private String email;
	private String password;
	private String passwordConfirmation;
	private boolean isActive;
	
    @Enumerated(EnumType.STRING)
	private Role role;
    
    
    

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long id, String userName, String email, String password, String passwordConfirmation, Role role, boolean isActive) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.role = role;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + ", role=" + role + "]";
	}





}
