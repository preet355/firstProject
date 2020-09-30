package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hsscconfig")
public class HsscConfig implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idHsscConfig")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idHsscConfig;

	@Column(name="hsscBaseFolderPath")
	private String hsscBaseFolderPath;

	public int getIdHsscConfig() {
		return idHsscConfig;
	}

	public void setIdHsscConfig(int idHsscConfig) {
		this.idHsscConfig = idHsscConfig;
	}

	public String getHsscBaseFolderPath() {
		return hsscBaseFolderPath;
	}

	public void setHsscBaseFolderPath(String hsscBaseFolderPath) {
		this.hsscBaseFolderPath = hsscBaseFolderPath;
	}
	
	

}
