package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Technical;
import mx.utng.practice.repository.TechnicalRepositoy;

@Named
@ViewScoped
public class TechnicalController {
	@Autowired
	private TechnicalRepositoy technicalRepositoy;
	private Technical technical = new Technical();
	private List<Technical> technicals;
	
	private boolean editMode = false;
	@PostConstruct
	public void init(){
		setTechnicals(technicalRepositoy.findAll());
	}
	
	public void save(){
		technicalRepositoy.save(technical);
		if(!editMode){
			getTechnicals().add(technical);
		}
		technical=new Technical();
		setEditMode(false);
	}
	
	public void delete(Technical technical){
		technicalRepositoy.delete(technical);
		technicals.remove(technical);
	}
	
	public void update(Technical technical){
		setTechnical(technical);
		setEditMode(true);
	}
	
	public void cancel(){
		technical = new Technical();
		setEditMode(false);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public TechnicalRepositoy getTechnicalRepositoy() {
		return technicalRepositoy;
	}
	
	public void setTechnicalRepositoy(TechnicalRepositoy technicalRepositoy) {
		this.technicalRepositoy = technicalRepositoy;
	}
	public Technical getTechnical() {
		return technical;
	}
	public void setTechnical(Technical technical) {
		this.technical = technical;
	}
	public List<Technical> getTechnicals() {
		return technicals;
	}
	public void setTechnicals(List<Technical> technicals) {
		this.technicals = technicals;
	}
	
	
	
}
