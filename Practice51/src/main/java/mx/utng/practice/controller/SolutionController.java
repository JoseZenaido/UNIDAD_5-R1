package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Solution;
import mx.utng.practice.repository.SolutionRepository;

@Named
@ViewScoped
public class SolutionController {
	@Autowired
	private SolutionRepository solutionRepository;
	private Solution solution = new Solution();
	private List<Solution> solutions ;
	
	
	private boolean editMode = false;
	@PostConstruct
	public void init(){
		setSolutions(solutionRepository.findAll());
	}
	public void save(){
		solutionRepository.save(solution);
		if(!editMode){
			getSolutions().add(solution);
		}
		solution=new Solution();
		setEditMode(false);
	}
	public void delete(Solution solution) {
		solutionRepository.delete(solution);
		solutions.remove(solution);
	}
	public void update(Solution solution){
		setSolution(solution);
		setEditMode(true);
	}
	public void cancel(){
		solution = new Solution();
		setEditMode(false);
	}
	
	public SolutionRepository getSolutionRepository() {
		return solutionRepository;
	}
	public void setSolutionRepository(SolutionRepository solutionRepository) {
		this.solutionRepository = solutionRepository;
	}
	
	public Solution getSolution() {
		return solution;
	}
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	public List<Solution> getSolutions() {
		return solutions;
	}
	
	

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

}///