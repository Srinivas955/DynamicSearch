package in.srinivas.service;

import java.util.List;

import in.srinivas.binding.PlanRequest;
import in.srinivas.binding.PlanResponce;

public interface InsurancePlanService {
	
	public List<PlanResponce> searchPlans(PlanRequest req);
	
	public List<String> getUniquePlanNames();
	
	public List<String> getUniquePlanStatus();

}
