package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departmentDocs")
public class DepartmentDocs implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDepartmentDocs", unique = true, nullable = false)
	private Integer idDepartmentDocs;
	
	@Column(name="dEpartmentId")
	private Integer dEpartmentId;
	
	@Column(name="sRNo")
	private Integer sRNo;
	
	@Column(name="docUrl")
	private String docUrl;
	
	@Column(name="docType")
	private String docType;
	
	@Column(name="fileName")
	private String fileName;

	public Integer getIdDepartmentDocs() {
		return idDepartmentDocs;
	}

	public void setIdDepartmentDocs(Integer idDepartmentDocs) {
		this.idDepartmentDocs = idDepartmentDocs;
	}

	public Integer getdEpartmentId() {
		return dEpartmentId;
	}

	public void setdEpartmentId(Integer dEpartmentId) {
		this.dEpartmentId = dEpartmentId;
	}

	public String getDocUrl() {
		return docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}
	
	

}
