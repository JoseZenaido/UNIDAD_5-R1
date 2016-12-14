package mx.utng.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="technicals")
public class Technical {
	@Id @GeneratedValue
	private Long id;
	private String technicalName;
	private String telephone;
	private String other;
	public Technical(String technicalName,String telephone,String other ){
		super();
		this.technicalName=technicalName;
		this.telephone=telephone;
		this.other=other;
	}
	public Technical(){
		this("","","");
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTechnicalName() {
		return technicalName;
	}
	public void setTechnicalName(String technicalName) {
		this.technicalName = technicalName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Technical [id=" + id + ", technicalName=" + technicalName
				+ ", telephone=" + telephone + ", other=" + other + "]";
	}
	
}
