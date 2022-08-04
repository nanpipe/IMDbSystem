package cl.talentoDigital.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@SequenceGenerator(name="SQ_SHOW", initialValue=1, allocationSize=1)
public class Show {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_SHOW")
	private Long id;
	private String showTitle;
	private String showNetwork;
	
	 @OneToMany(cascade= {CascadeType.REMOVE},mappedBy="rating",orphanRemoval=true)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 private List<Rating> ratings;
	
	 
	public Show() {
	}

	public Show(Long id, String showTitle, String showNetwork) {
		super();
		this.id = id;
		this.showTitle = showTitle;
		this.showNetwork = showNetwork;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public String getShowNetwork() {
		return showNetwork;
	}

	public void setShowNetwork(String showNetwork) {
		this.showNetwork = showNetwork;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", showTitle=" + showTitle + ", showNetwork=" + showNetwork + "]";
	}
}
