package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interimOrder")
public class InterimOrderDetails implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId", unique = true, nullable = false)
	private Integer orderId;
	
	@Column(name = "caseId")
	private Integer caseId;
	
	@Column(name = "fullInterimOrder")
	private String fullInterimOrder;
	
	@Column(name="interimOrderDate")
    private String interimOrderDate;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getFullInterimOrder() {
		return fullInterimOrder;
	}

	public void setFullInterimOrder(String fullInterimOrder) {
		this.fullInterimOrder = fullInterimOrder;
	}

	public String getInterimOrderDate() {
		return interimOrderDate;
	}

	public void setInterimOrderDate(String interimOrderDate) {
		this.interimOrderDate = interimOrderDate;
	}
	
  
}
