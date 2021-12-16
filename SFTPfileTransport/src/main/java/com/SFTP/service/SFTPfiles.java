package com.SFTP.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.SFTP.SftPfileTransportApplication;
import com.SFTP.Entity.ApprovalMatrix;
import com.SFTP.Entity.GLcodeMaster;
import com.SFTP.Entity.HRheirarchyMaster;
import com.SFTP.Entity.PoHeader_Master;
import com.SFTP.Entity.VendorMaster;
import com.SFTP.Persistance.ApMatrixJPA;
import com.SFTP.Persistance.GLcodeMasterJPA;
import com.SFTP.Persistance.HRheirarchyMasterJPA;
import com.SFTP.Persistance.POheaderMasterJPA;
import com.SFTP.Persistance.VendorMasterJPA;
//import com.SFTP.Persistance.SupplyerPersistance;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;


//import jdk.javadoc.internal.doclets.formats.html.markup.Head;

@Service
public class SFTPfiles extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ApprovalMatrixIMPL apMatrixIMPL;
	@Autowired
	private GLcodIMPL GLcodeIMPL;
	@Autowired
	private HRheirarchyMasterIMPL HrMasterIMPL;
	@Autowired
	private POheaderMasterIMPL PoHeaderIMPL;
	@Autowired
	private VendorMasterIMPL VendorMasterIMPL;
	@Autowired
	private convertCSV convertCSV;
	
	Vector<ChannelSftp.LsEntry> clist;
	public Vector<ChannelSftp.LsEntry> xlist;

//	int count = 0;
	JSch jsch = new JSch();
	Session session = null;
	String file_data_exc = "";
	ChannelSftp sftpCHANNEL;
	List<String> fileList = new ArrayList<String>();
//	org.apache.log4j.Logger logger = (Logger) LogManager.getLogger(SFTPfiles.class);

	@SuppressWarnings("deprecation")
	public void test() throws SftpException, IOException {
		try {

			System.out.println("inside try");
			session = jsch.getSession("tester", "192.168.137.1", 22);

			System.out.println("session created");

			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			System.out.println("Authenticating......");

			session.setPassword("password");
			session.connect();
			System.out.println("session connected");

			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			this.sftpCHANNEL = sftpChannel;
			System.out.println("pgrm strt");
			

			clist = sftpChannel.ls("*.csv");
			//Vector<ChannelSftp.LsEntry> clist = sftpChannel.ls("*");
			
			for (ChannelSftp.LsEntry entry1 : clist) {
				System.out.println(entry1.getFilename());
				fileList.add(entry1.getFilename());
			}
			
			
			xlist = sftpChannel.ls("*.xlsx");
			for (ChannelSftp.LsEntry entry2 : xlist) {
				System.out.println(entry2.getFilename());
				convertCSV.cnvtCSV(entry2.getFilename(), sftpChannel);
			}
			
//			for (ChannelSftp.LsEntry entry2 : xlist ) {
//				
//				System.out.println(sftpChannel.pwd());
//				File file = new File(sftpChannel.pwd()+entry2.getFilename());
//				
//				FileInputStream fis=new FileInputStream(file);
//				
//				XSSFWorkbook wb = new XSSFWorkbook(fis);
//				XSSFSheet sheet = wb.getSheetAt(0);
//				
//				Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
//				while (itr.hasNext())                 
//				{  
//				Row row = itr.next();  
//				Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
//				while (cellIterator.hasNext())   
//				{  
//				Cell cell = cellIterator.next();  
//				switch (cell.getCellType())               
//				{  
//				case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
//				System.out.print(cell.getStringCellValue() + "\t\t\t");  
//				break;  
//				case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
//				System.out.print(cell.getNumericCellValue() + "\t\t\t");  
//				break;  
//				default:  
//				}  
//				}  
//				System.out.println("");  
//				}  
//				System.out.println(); 
//				fileList.add(entry2.toString());
//			}

			for (String s : fileList) {

				InputStream stream = sftpChannel.get(s);
				if (s.substring(0, 6).equalsIgnoreCase("APPROV")) {
					apMatrixIMPL.Approval_matrixSrevice(stream, s, sftpChannel);
				} else if (s.substring(0, 2).equalsIgnoreCase("HR")) {
					HrMasterIMPL.HR_masterIMPL(stream, s, sftpChannel);
				} else if (s.substring(0, 2).equalsIgnoreCase("PO")) {
					PoHeaderIMPL.Po_headerIMPL(stream, s, sftpChannel);
				} else if (s.substring(0, 2).equalsIgnoreCase("GL")) {
					GLcodeIMPL.GLcodeMaster(stream, s, sftpChannel);
				} else if (s.substring(0, 6).equalsIgnoreCase("VENDOR")) {
					VendorMasterIMPL.Vendor_masterIMPL(stream, s, sftpChannel);
				}
			}

			sftpChannel.exit();
			session.disconnect();
		} catch (JSchException e) {
			e.printStackTrace();
		}
	}

}
