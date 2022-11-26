package in.srinivas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.srinivas.binding.PlanRequest;
import in.srinivas.binding.PlanResponce;
import in.srinivas.entity.InsurancePlan;
import in.srinivas.repository.InsurancePlanRepository;

@Service
public class InsuranceServicePlanImpl implements InsurancePlanService {

	@Autowired
	private InsurancePlanRepository planRepo;
	
	@Override
	public List<PlanResponce> searchPlans(PlanRequest req) {
		
		InsurancePlan entity = new InsurancePlan();
		
		if(req!=null && req.getPlanName()!=null && !req.getPlanStatus().equals("")) {
			entity.setPlanName(req.getPlanName());
		}
		if(req!=null && req.getPlanStatus()!=null && !req.getPlanStatus().equals("")) {
			entity.setPlanStatus(req.getPlanStatus());
		}
			Example<InsurancePlan> example = Example.of(entity);
			List<InsurancePlan> findAll = planRepo.findAll(example);
			
			List<PlanResponce> plans = new ArrayList<>();
			for(InsurancePlan ip : findAll) {
				PlanResponce response = new PlanResponce();
				BeanUtils.copyProperties(ip, response);
				plans.add(response);
			}
		return plans;
	}

	@Override
	public List<String> getUniquePlanNames() {
		List<String> planName = planRepo.getPlanName();
		return planName;
	}

	@Override
	public List<String> getUniquePlanStatus() {
		List<String> planStatus = planRepo.getPlanStatus();
		return planStatus;
	}

}
