package cl.talentoDigital.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="SQ_RATING", initialValue=1, allocationSize=1)
public class Rating {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_RATING")
	private Long id;
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "show_id", referencedColumnName = "id")
	private Show show;
	
	public Rating() {
	}


	public Rating(Long id, int rating, Usuario usuario, Show show) {

		super();
		this.id = id;
		this.rating = rating;
		this.usuario = usuario;
		this.show = show;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Usuario getUser() {
		return usuario;
	}

	public Usuario setUsuario(Usuario usuario) {
		this.usuario = usuario;
		return usuario;
	}

	public void setUser(Usuario usuario) {
		this.usuario = usuario;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", user=" + usuario + ", show=" + show + "]";
	}
}
