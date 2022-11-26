package in.srinivas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Insurance_Plan")
public class InsurancePlan {
	
	@Id
	@GeneratedValue
	@Column(name="Plan_Id")
	private Integer planId;
	
	@Column(name="Plan_Name")
	private String planName;
	
	@Column(name="Plan_Status")
	private String planStatus;
	
	@Column(name="Holder_Name")
	private String holderName;
	
	@Column(name="Benifit_Amount")
	private String benifitAmt;


}
