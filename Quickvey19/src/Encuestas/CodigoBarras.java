/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encuestas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CodigoBarras {        
    public static void main(String[] args) {
        try {
            Document documento = new Document() {};
            
            PdfWriter reporte = PdfWriter.getInstance(documento, new FileOutputStream("CodigoBarras.pdf"));
            documento.open();
            
            Barcode39 codigo = new Barcode39();
            codigo.setCode("161220201200");
            Image imagenCodigo = codigo.createImageWithBarcode(reporte.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            
            documento.add(imagenCodigo);
            
            documento.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodigoBarras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CodigoBarras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}