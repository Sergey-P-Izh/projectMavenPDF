import com.itextpdf.text.*;
import  com.itextpdf.text.pdf.*;

import javax.swing.text.Document;
import javax.swing.text.ParagraphView;
import java.io.FileOutputStream;

class PDFGenerator{
    private String file;
    private Document document;
    private BaseFont bf;
    public PDFGenerator(String path){
        file = path;
        try {
            document = new Document();
            pdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
        }
        catch (Exception ex){}
    }
    public  void addTitle(String msg){
        try{
            bf = BaseFont.createFont("c:/windows/fonts/times.tff", BaseFont.EMBEDDED);
            Paragraph preface = new Paragraph();
            Font rus_font = new Font(bf, 18, Font.NORMAL);
            preface.add(new Paragraph("Hello world", rus_font));
            preface.add(new Paragraph(msg, rus_font));
            try {
                document.add(preface);
            }
            catch (Exception er){}
            document.newPage();
        }
        catch (Exception ex) {};
    }
    public void  doClose(){
        document.close();
    }
}
public class App
{
    public void  main (String[] args) {
        System.out.println("Hello world!");
        PDFGenerator report = new PDFGenerator("report.pdf");
        report.addTitle("Something on English");
        report.doClose();
    }
}