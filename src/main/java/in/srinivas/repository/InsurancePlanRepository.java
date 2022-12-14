package in.srinivas.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.srinivas.entity.InsurancePlan;

public interface InsurancePlanRepository extends JpaRepository<InsurancePlan, Serializable> {
	
	@Query("select distinct planName from InsurancePlan")
	public List<String> getPlanName( );
	
	@Query("select distinct planStatus from InsurancePlan")
	public List<String> getPlanStatus();

}
