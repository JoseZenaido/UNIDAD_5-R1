package mx.utng.practice.repository;

import java.util.List;

import mx.utng.practice.model.Solution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
	@Query("select solu from Solution solu")
	public List<Solution>findAll();
}
