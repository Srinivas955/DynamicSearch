package in.srinivas.reports;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.srinivas.binding.PlanResponce;

public class ExcelReport {
	
	public void export(List<PlanResponce> plan, HttpServletResponse response) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Insurance Plans");
		XSSFRow headerRow = sheet.createRow(0); 
		
		headerRow.createCell(0).setCellValue("planId");
		headerRow.createCell(1).setCellValue("planName");
		headerRow.createCell(2).setCellValue("planStatus");
		headerRow.createCell(3).setCellValue("holderName");
		headerRow.createCell(4).setCellValue("benifitAmt");
		
		for(int i = 0; i < plan.size(); i++) {
			PlanResponce planResponce = plan.get(i);
			XSSFRow createRow = sheet.createRow(i + 1);
			createRow.createCell(0).setCellValue(planResponce.getPlanId());
			createRow.createCell(1).setCellValue(planResponce.getPlanName());
			createRow.createCell(2).setCellValue(planResponce.getPlanStatus());
			createRow.createCell(3).setCellValue(planResponce.getHolderName());
			createRow.createCell(4).setCellValue(planResponce.getBenifitAmt());
		}
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
