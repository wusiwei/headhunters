package com.lietou.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.docx4j.Docx4J;
import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Tr;


public class DocxUtil {
	
	public static void main(String[] args) {
		try {
			WordprocessingMLPackage template = WordprocessingMLPackage.load(new File("C://Users//96910//Desktop//ceshi.docx"));
			Docx4jUtil docx4jUtil=new Docx4jUtil();
			MainDocumentPart mainDocPart = template.getMainDocumentPart();
			/*List<Object> tcList=Docx4jUtil.getAllElementFromObject(mainDocPart,Tc.class);
			for (Object o : tcList) {
	            try {
					System.out.println(docx4jUtil.getElementContent(o));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }*/
			/*List<Tbl> getAllTbl=docx4jUtil.getAllTbl(template);
			for(Tbl t : getAllTbl){
				try {
					System.out.println("表格----"+docx4jUtil.getElementContent(t));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					//System.out.println(docx4jUtil.getTblContentStr(t));
					List<String> strList=docx4jUtil.getTblContentList(t);
					List<Tr> trList=docx4jUtil.getTblAllTr(t);
					for(Tr tr : trList){
						List<Tc> tcList = docx4jUtil.getTrAllCell(tr);
						for(Tc tc : tcList){
							System.out.println(docx4jUtil.getElementContent(tc));
						}
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			try {
				Docx4J.toHTML(template, "html/resources", "resources", new FileOutputStream(new File("C://Users//96910//Desktop//ceshi.html")));
				WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
				XHTMLImporterImpl xhtmlImporter = new XHTMLImporterImpl(wordMLPackage);
				wordMLPackage.getMainDocumentPart().getContent().addAll(xhtmlImporter.convert(new File("C://Users//96910//Desktop//ceshi.html"), ""));
				wordMLPackage.save(new File("C://Users//96910//Desktop//ceshi2.docx"));
				
				HtmlConverter htmlConverter=new HtmlConverter();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Docx4JException e) {
			e.printStackTrace();
		}
	}

}

