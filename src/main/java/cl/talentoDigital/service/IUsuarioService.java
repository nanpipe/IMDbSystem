package cl.talentoDigital.service;

import java.util.List;
import java.util.Optional;

import cl.talentoDigital.model.Usuario;

public interface IUsuarioService{

	public List<Usuario> findAll();
	public void save(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public Optional<Usuario> findByUsername(String username);
	public List<Usuario> findByEmailLike(String email);
}
