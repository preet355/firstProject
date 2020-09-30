package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requisitionDocs")
public class RequisitionDocs implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idrequistionDocs", unique = true, nullable = false)
	private Integer idrequistionDocs;
	
	@Column(name="idrequisition")
	private Integer idRequisition;
	
	@Column(name="docUrl")
	private String docUrl;
	
	@Column(name="docType")
	private String docType;
	
	@Column(name="fileName")
	private String fileName;

	public Integer getIdrequistionDocs() {
		return idrequistionDocs;
	}

	public void setIdrequistionDocs(Integer idrequistionDocs) {
		this.idrequistionDocs = idrequistionDocs;
	}

	public Integer getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Integer idRequisition) {
		this.idRequisition = idRequisition;
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
	
	

}
