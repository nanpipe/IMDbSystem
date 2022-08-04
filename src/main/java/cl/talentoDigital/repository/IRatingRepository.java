package cl.talentoDigital.repository;

import org.springframework.data.repository.CrudRepository;

import cl.talentoDigital.model.Rating;

public interface IRatingRepository extends CrudRepository<Rating, Long> {
	
	Rating findByUsuarioIdAndShowId(Long usuarioId, Long showId);
	void deleteByShowId(Long showId);


}
