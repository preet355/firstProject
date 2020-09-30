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
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table(name = "examdetails")
public class ExamDetails implements Serializable{
	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "examId", unique = true, nullable = false)
	private Integer examId;
	
	@Column(name = "examName")
	private String examName;
	
	@Column(name = "nameOfPost")
	private String nameOfPost;
	
	@Column(name = "catNo")
	private String catNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="examDate")
	private Date examDate;
	
	@Column(name = "examTime")
	private String examTime;
	
	@Column(name="sortBy")
	private String sortBy;
	
	@Column(name="advtNo")
	private String advtNo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedDate")
	private Date updatedDate;
	
	@LazyCollection(LazyCollectionOption.FALSE)	
	@OneToMany(mappedBy = "examId", targetEntity = ExamCenterAllocation.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ExamCenterAllocation> allcationList;
	
	@Transient
	private String bgcolor;

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public String getNameOfPost() {
		return nameOfPost;
	}

	public void setNameOfPost(String nameOfPost) {
		this.nameOfPost = nameOfPost;
	}

	public String getCatNo() {
		return catNo;
	}

	public void setCatNo(String catNo) {
		this.catNo = catNo;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public List<ExamCenterAllocation> getAllcationList() {
		return allcationList;
	}

	public void setAllcationList(List<ExamCenterAllocation> allcationList) {
		this.allcationList = allcationList;
	}

	public String getAdvtNo() {
		return advtNo;
	}

	public void setAdvtNo(String advtNo) {
		this.advtNo = advtNo;
	}
	
	
}
