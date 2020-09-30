package in.hkcl.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="validatebifurcation")
public class ValidateBifurcation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idvalidatebifurcation", unique = true, nullable = false)
	private Integer idvalidatebifurcation;
	 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="viewedon")
	private Date viewedon;
	
	@Column(name="dEpartmentId")
	private Integer dEpartmentId;
	
	@Column(name="fieldOfficeName")
	private String fieldOfficeName;
	
	@Column(name="noofposts")
	private Integer noofposts;
	
	@Column(name="previousrosterpoint")
	private Integer previousrosterpoint;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "idvalidatebifurcation", targetEntity = ValidateBifurcationCounts.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ValidateBifurcationCounts> bifurcationCountList;
	
	
	public Integer getIdvalidatebifurcation() {
		return idvalidatebifurcation;
	}

	public void setIdvalidatebifurcation(Integer idvalidatebifurcation) {
		this.idvalidatebifurcation = idvalidatebifurcation;
	}

	public Date getViewedon() {
		return viewedon;
	}

	public void setViewedon(Date viewedon) {
		this.viewedon = viewedon;
	}

	public Integer getdEpartmentId() {
		return dEpartmentId;
	}

	public void setdEpartmentId(Integer dEpartmentId) {
		this.dEpartmentId = dEpartmentId;
	}

	public String getFieldOfficeName() {
		return fieldOfficeName;
	}

	public void setFieldOfficeName(String fieldOfficeName) {
		this.fieldOfficeName = fieldOfficeName;
	}

	public Integer getNoofposts() {
		return noofposts;
	}

	public void setNoofposts(Integer noofposts) {
		this.noofposts = noofposts;
	}

	public Integer getPreviousrosterpoint() {
		return previousrosterpoint;
	}

	public void setPreviousrosterpoint(Integer previousrosterpoint) {
		this.previousrosterpoint = previousrosterpoint;
	}

	
	
}
