package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nextsteps")
public class NextStepsAdvt implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idNextStep", unique = true, nullable = false)
	private Integer idNextStep;
	
	@Column(name="nextStep")
	private String nextStep;

	public Integer getIdNextStep() {
		return idNextStep;
	}

	public void setIdNextStep(Integer idNextStep) {
		this.idNextStep = idNextStep;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	
}
