package com.SFTP.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jcraft.jsch.ChannelSftp;
import com.opencsv.CSVWriter;

@Service
public class convertCSV {

	@Autowired
	private SFTPfiles sftpFiles;
	@Autowired
	private ApprovalMatrixIMPL apMatrixIMPL;
	String fileName = "csvData";
	private static final String exelPath= "C:/Users/lenovo/Downloads/data/";
	StringBuffer data = new StringBuffer();
	File outputFile = null;
	File inputFile = null;
	@SuppressWarnings("deprecation")
	public void cnvtCSV(String xlFile,ChannelSftp sftpChannel) throws IOException {
		System.out.println("-----------------------> inside csv convert");
		System.out.println("------------------------> file converting----->"+xlFile);
		StringBuffer data = new StringBuffer();
		
		try {
			outputFile = new File("./src/main/resources/Approval_matrixCSV.csv");
			inputFile = new File(exelPath+xlFile);
			 FileOutputStream fos = new FileOutputStream(outputFile);
	            // Get the workbook object for XLSX file
	            FileInputStream fis = new FileInputStream(inputFile);
	            Workbook workbook = null;

	            String ext = FilenameUtils.getExtension(inputFile.toString());

	            if (ext.equalsIgnoreCase("xlsx")) {
	                workbook = new XSSFWorkbook(fis);
	            } else if (ext.equalsIgnoreCase("xls")) {
	                workbook = new HSSFWorkbook(fis);
	            }

	            // Get first sheet from the workbook

	            //int numberOfSheets = workbook.getNumberOfSheets();
	            int numberOfSheets = 1;
	            Row row;
	            Cell cell;
	            // Iterate through each rows from first sheet

	            for (int i = 0; i < numberOfSheets; i++) {
	                Sheet sheet = workbook.getSheetAt(0);
	                Iterator<Row> rowIterator = sheet.iterator();

	                while (rowIterator.hasNext()) {
	                    row = rowIterator.next();
	                    // For each row, iterate through each columns
	                    Iterator<Cell> cellIterator = row.cellIterator();
	                    while (cellIterator.hasNext()) {

	                        cell = cellIterator.next();

	                        switch (cell.getCellType()) {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            data.append(cell.getBooleanCellValue() + ",");

	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:
	                            data.append(cell.getNumericCellValue() + ",");

	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                            data.append(cell.getStringCellValue() + ",");
	                            break;

	                        case Cell.CELL_TYPE_BLANK:
	                            data.append("" + ",");
	                            break;
	                        default:
	                            data.append(cell + ",");

	                        }
	                    }
	                    data.append('\n'); // appending new line after each row
	                }

	            }
	            fos.write(data.toString().getBytes());
	            fos.close();
	            FileInputStream exlIstream = new FileInputStream(this.outputFile);
	            System.out.println("File sento Approval_matrix : "+outputFile.getName());
	            apMatrixIMPL.Approval_matrixSrevice(exlIstream, outputFile.getName(), sftpFiles.sftpCHANNEL);
	            
//	            sftpFiles.clist.
//		System.out.println("csv converting..........");
//		System.out.println(xlFile);
//		System.out.println(" before input Stream++++++++"+exelPath+xlFile);
//		System.out.println("excel path"+exelPath+xlFile);
//        FileInputStream input_document = new FileInputStream(new File(exelPath+xlFile));
//        System.out.println("after input Stream+++++++++"+sftpChannel.pwd()+exelPath+xlFile);
//        StringBuffer data = new StringBuffer();
        
       /* XSSFWorkbook my_xls_workbook = new XSSFWorkbook(input_document); 
        
        XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
        
        Iterator<Row> rowIterator = my_worksheet.iterator();
        
        File csv = new File("./src/main/resources/"+xlFile);
        FileWriter my_csv=new FileWriter(csv);
        CSVWriter my_csv_output=new CSVWriter(my_csv); 
        
        while(rowIterator.hasNext()) {
                Row row = rowIterator.next(); 
                int i=0;
                String[] csvdata = new String[2];
                int val;
                Iterator<Cell> cellIterator = row.cellIterator();
                        while(cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                switch(cell.getCellType()) { 
                                case Cell.CELL_TYPE_STRING:
                                        csvdata[i]= cell.getStringCellValue();                                              
                                case Cell.CELL_TYPE_NUMERIC:
                                	csvdata[i]= cell.
                                	break;
                                }
                                i=i+1;
                        }
        my_csv_output.writeNext(csvdata);
        }
        my_csv_output.close();
        
        input_document.close();
		*/
		} catch (Exception e) {
			e.printStackTrace();
					}
		
	
}
}