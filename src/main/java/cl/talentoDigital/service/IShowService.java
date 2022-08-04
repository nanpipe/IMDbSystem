package cl.talentoDigital.service;

import java.util.List;
import java.util.Optional;

import cl.talentoDigital.model.Show;

public interface IShowService {

	public List<Show> findAll();
	public List<Show> findByShowTitle(String showTitle);
	public void save(Show show);
	public void deleteById(Long id);
	public void update(Show show);
	public Optional<Show> findById(Long idShow);
}
