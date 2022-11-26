package in.srinivas.reports;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.srinivas.binding.PlanResponce;

public class PdfReports {
	
	public void export(List<PlanResponce> plans, HttpServletResponse response) throws Exception {
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();	
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.blue);		
		Paragraph p = new Paragraph("List Of Plans", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);		
		document.add(p);
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f, 1.5f, 2.0f, 3.0f, 2.0f} );
		table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font1.setColor(Color.BLACK);
		
		cell.setPhrase(new Phrase("planId", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("planName", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("planStatus", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("holderName", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("benifitAmt", font1));
		table.addCell(cell);
		
		for(PlanResponce plan : plans) {
			table.addCell(String.valueOf(plan.getPlanId()));
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getHolderName());
			table.addCell(plan.getBenifitAmt());			
		}
		document.add(table);
		document.close();
		
	}

}
