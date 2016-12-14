package mx.utng.practice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.utng.practice.model.Employee;;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	@Query("select emp from Employee emp")
	public List<Employee>findAll();
}//
