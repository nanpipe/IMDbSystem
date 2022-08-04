package cl.talentoDigital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.talentoDigital.model.Show;

public interface IShowRepository extends CrudRepository<Show, Long> {

	List<Show> findByShowTitleLike(String showTitle);
}
