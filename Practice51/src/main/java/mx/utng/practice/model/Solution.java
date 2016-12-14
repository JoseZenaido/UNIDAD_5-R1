package mx.utng.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="solutions")
public class Solution {
	@Id @GeneratedValue
	private Long id;
	private String idHistoryProblem;
	private String descriptionProblem;
	public Solution(String idHistoryProblem,String descriptionProblem){
		super();
		this.idHistoryProblem=idHistoryProblem;
		this.descriptionProblem=descriptionProblem;
	}
	public Solution(){
		this("","");
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdHistoryProblem() {
		return idHistoryProblem;
	}
	public void setIdHistoryProblem(String idHistoryProblem) {
		this.idHistoryProblem = idHistoryProblem;
	}
	public String getDescriptionProblem() {
		return descriptionProblem;
	}
	public void setDescriptionProblem(String descriptionProblem) {
		this.descriptionProblem = descriptionProblem;
	}
	@Override
	public String toString() {
		return "Solution [id=" + id + ", idHistoryProblem=" + idHistoryProblem
				+ ", descriptionProblem=" + descriptionProblem + "]";
	}

}//
