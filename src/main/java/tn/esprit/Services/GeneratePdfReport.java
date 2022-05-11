package tn.esprit.Services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.var;


import tn.esprit.Controller.FactureRestController;
import tn.esprit.Entities.facture;
import tn.esprit.Entities.panierProduit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import tn.esprit.Services.IPanierProduitService;

public class GeneratePdfReport {

    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

    public static ByteArrayInputStream factureReport(facture f, List<panierProduit> panier) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
        	

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(80);
            table.setWidths(new int[]{4, 2, 2, 2});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Produit", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Prix Unitaire", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Quantité", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Prix", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
           
                
            // Tableau loop
            
            
			for (panierProduit pp : panier) {
				

           PdfPCell cell;

                cell = new PdfPCell(new Phrase(pp.getProduit().getLibelleProduit().toString()));
            	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	table.addCell(cell);
            
			
			   cell = new PdfPCell(new Phrase(Float.toString(pp.getProduit().getPrix()))); 
	           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	           table.addCell(cell);
	           
	           //cell = new PdfPCell(new Phrase(pp.getQte().toString()));
	           cell = new PdfPCell(new Phrase (Integer.toString(pp.getQuantity())));  
	           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	           table.addCell(cell);
	           
	           cell = new PdfPCell(new Phrase(Float.toString(pp.getSomme())));
	           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	           table.addCell(cell);
	        
			}
            
            // Tableau   
            

            PdfWriter.getInstance(document, out);
            document.open();
            
            
            document.add(new Paragraph("Cher Client, "+f.getUser().getUsername()));
            document.add(new Paragraph("Date: "+new Date().toString()));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            //document.add(new Paragraph("Id de votre facture: "+f.getIdFacture()));
            document.add(new Paragraph("Type du facture: "+f.getType()));
            document.add(new Paragraph("Etat de livraison: "+f.getEtat_livraison()));
            document.add(new Paragraph("Date de paiement: "+f.getPaiement().getDate().toString()));
            document.add(new Paragraph("Nature de paiement: "+f.getPaiement().getNature().toString()));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("List des Produits achetés:"));
            document.add(new Paragraph("\n"));
            document.add(table);
            document.add(new Paragraph("Prix a payer (avec TvA) : "+Float.toString(f.getPaiement().getSommetotal()))); 
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Consomi tounsi et a bientot"));

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}

