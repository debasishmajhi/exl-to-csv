package com.SFTP.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SFTP.Entity.GLcodeMaster;
import com.SFTP.Persistance.GLcodeMasterJPA;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

@Service
public class GLcodIMPL {

	@Autowired
	private GLcodeMasterJPA GLcodeJPA;
	
	BufferedReader br;
	List<String> test = new ArrayList<>();
	String file_data_exc = "";
	
	public void GLcodeMaster(InputStream GLcodeIMPL,String s,ChannelSftp sftpChannel) throws SftpException, IOException{
		System.out.println("+++++++++++++++ inside GLcode ++++++++++++++");
		try {
			br = new BufferedReader(new InputStreamReader(GLcodeIMPL));
			String line;
			int count=0;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String file_data = line;
				file_data_exc = file_data;
				if (count == 0) {
					count++;
					continue;
				} else { 
					String[] data = line.split(",");
					if (data.length == 12) {

						GLcodeMaster glMaster = new GLcodeMaster();
						glMaster.setBusiness_unit(data[0]);
						glMaster.setCorporate_Division_Code(data[1]);
						glMaster.setCorp_Div_Description(data[2]);
						glMaster.setDept_Code(data[3]);
						glMaster.setDept_Description_Code(data[4]);
						glMaster.setLIB_code(data[5]);
						glMaster.setLIB_description(data[6]);
						glMaster.setGLA_account(data[7]);
						glMaster.setGLA_account_description(data[8]);
						glMaster.setStart_date_active(null);
						glMaster.setEnd_date_active(null);
						glMaster.setActiveInactive(data[11]);
						GLcodeJPA.save(glMaster);
						System.out.println("--------------> GLcode DB");
						
					} else {
						test.add(file_data);		
					}
				}
			}  
		} catch (Exception e) {
			test.add(file_data_exc);
		}
		finally {
			if(!test.isEmpty()) {
			File glFILE = new File("./src/main/resources/ERR_"+s);
			FileWriter writer = new FileWriter(glFILE);
			String collect = test.stream().collect(Collectors.joining("\n"));
			writer.write(collect);
			writer.close();
			sftpChannel.put("./src/main/resources/ERR_"+s,sftpChannel.pwd()+"error1/"+s);
			glFILE.delete();
			}
			}
		
	}
	
}
