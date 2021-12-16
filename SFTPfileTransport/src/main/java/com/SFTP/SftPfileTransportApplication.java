package com.SFTP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


//import com.SFTP.Persistance.SupplyerPersistance;
import com.SFTP.service.SFTPfiles;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
//import com.sun.tools.javac.util.BasicDiagnosticFormatter.BasicConfiguration;

@SpringBootApplication
public class SftPfileTransportApplication {
	
//	@Autowired
//	private  SupplyerDetails splDtl;
	@Autowired
	private SFTPfiles file;
	//private SupplyerPersistance supplyPersist;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SftPfileTransportApplication.class, args);
		
	
//	@Autowired 
//	SupplyerPersistance supplyPersist;
//
//		JSch jsch = new JSch();
//		Session session = null;
//		org.apache.log4j.Logger logger = LogManager.getLogger(SftPfileTransportApplication.class);
//		BasicConfigurator.configure();
//		
//		int count = 0;
//		try {
//			
//			//final SFTPlocation = 
//			System.out.println("inside try");
//			session = jsch.getSession("tester", "192.168.1.68", 22);
//
//			System.out.println("session created");
//
//			Properties config = new Properties();
//			config.put("StrictHostKeyChecking", "no");
//			session.setConfig(config);
//			System.out.println("Authenticating......");
//
//			session.setPassword("password");
//			session.connect();
//			// session.setTimeout(6000);
//			System.out.println("session connected");
//
//			Channel channel = session.openChannel("sftp");
//			channel.connect();
//			ChannelSftp sftpChannel = (ChannelSftp) channel;
//  
//			System.out.println("pgrm strt");
//			List<String> fileList = new ArrayList<String>();
//			
//
//			Vector<ChannelSftp.LsEntry> list = sftpChannel.ls("*.csv");
//			for(ChannelSftp.LsEntry entry: list) {
////				System.out.println("FileName is: "+entry.getFilename());
//				fileList.add(entry.getFilename());
//			}
//			
//			for(String s:fileList) {
//				System.out.println("FILE NAME IS: "+s);
//				InputStream stream = sftpChannel.get(s);
//				try {
//					BufferedReader br = new BufferedReader(new InputStreamReader(stream));
//					String line;
//					while ((line = br.readLine()) != null) {
//						System.out.println(line);
//						count = count + 1;
//						if (count == 1) {
//							continue;
//						} else {
//							String[] data = line.split(",");
//							System.out.println(data[0]);
//						}
//					}
//
//				} catch (IOException io) {
//					System.out.println("Exception occurred during reading file from SFTP server due to " + io.getMessage());
//					io.getMessage();
//
//				} catch (Exception e) {
//					System.out.println("Exception occurred during reading file from SFTP server due to " + e.getMessage());
//					e.getMessage();
//
//				}
//				
//			}
//			
//			sftpChannel.exit();
//			session.disconnect();
//		} catch (JSchException e) {
//			e.printStackTrace();
//		} catch (SftpException e) {
//			e.printStackTrace();
//		}
		
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args ->{
			
			
//			 SFTPfiles sf = new SFTPfiles();
//			 sf.test();
			 System.out.println("Programm executed");
			 
			 String[] beanNames = ctx.getBeanDefinitionNames();
			 Arrays.sort(beanNames);
			file.test(); 
			 for (String beanName : beanNames) {
				//System.out.println(beanName);
			}
			 
		};
		
	}
}
