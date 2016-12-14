package mx.utng.practice.repository;

import java.util.List;

import mx.utng.practice.model.Technical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepositoy extends JpaRepository<Technical, Long> {
	@Query("select tec from Technical tec")
	public List<Technical>findAll();
}
