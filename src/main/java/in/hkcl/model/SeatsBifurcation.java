package in.hkcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seatsBifurcation")
public class SeatsBifurcation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bifurcationId", unique = true, nullable = false)
	private Integer bifurcationId;

	@Column(name = "category")
	private String category;
	
	@Column(name="subCategory")
	private String subCategory;
	
	@Column(name = "rosterPoints")
	private Integer rosterPoints;
	
	@Column(name = "series")
	private Integer series;

	public Integer getBifurcationId() {
		return bifurcationId;
	}

	public void setBifurcationId(Integer bifurcationId) {
		this.bifurcationId = bifurcationId;
	}

	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Integer getRosterPoints() {
		return rosterPoints;
	}

	public void setRosterPoints(Integer rosterPoints) {
		this.rosterPoints = rosterPoints;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}
	
	
	
}
