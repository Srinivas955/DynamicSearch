package in.srinivas.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.srinivas.binding.PlanRequest;
import in.srinivas.binding.PlanResponce;
import in.srinivas.reports.ExcelReport;
import in.srinivas.reports.PdfReports;
import in.srinivas.service.InsurancePlanService;

@RestController
public class InsurancePlanRestCntroller {
	
	@Autowired
	private InsurancePlanService service;
	
	@PostMapping(value = "/plans")
	public ResponseEntity<List<PlanResponce>> searchPlan(@RequestBody PlanRequest req){
		List<PlanResponce> searchPlans = service.searchPlans(req);
		return new ResponseEntity<>(searchPlans, HttpStatus.OK);
	}
	
	@GetMapping(value = "/plannames")
	public ResponseEntity<List<String>> getPlanNames(){
		List<String> uniquePlanNames = service.getUniquePlanNames();
		return new ResponseEntity<>(uniquePlanNames, HttpStatus.OK);
	}
	
	@GetMapping(value = "/planstatus")
	public ResponseEntity<List<String>> getPlanStatus(){
		List<String> uniquePlanStatus = service.getUniquePlanStatus();
		return new ResponseEntity<>(uniquePlanStatus, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/excel")
	public void generateExcel(HttpServletResponse respons) throws Exception {
		respons.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachement; fileName=plans.xlsx"; 
		
		respons.setHeader(headerKey, headerValue);
		
		List<PlanResponce> searchPlans = service.searchPlans(null);
		ExcelReport excel = new ExcelReport();
		excel.export(searchPlans, respons);
	}
	
	@GetMapping(value="/pdf")
	public void generatePdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String HeaderValue = "attachement; fileName=Plans.pdf";
		
		response.setHeader(headerKey, HeaderValue);
		
		List<PlanResponce> searchPlans = service.searchPlans(null);
		PdfReports pdf = new PdfReports();
		pdf.export(searchPlans, response);
		
	}
	
	
		

}
