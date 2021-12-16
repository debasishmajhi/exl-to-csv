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

import com.SFTP.Entity.ApprovalMatrix;
import com.SFTP.Persistance.ApMatrixJPA;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

@Service
public class ApprovalMatrixIMPL {

	
	@Autowired
	private ApMatrixJPA apMatrix;
	
	BufferedReader br;
	List<String> test = new ArrayList<>();
	String file_data_exc = "";
	
	public void Approval_matrixSrevice(InputStream APmatrixFile,String s,ChannelSftp sftpChannel) throws SftpException, IOException{
		System.out.println("++++++++++++++inside Approvalmatrix +++++++++++++++++");
		System.out.println("--------------> file xlsx name : "+APmatrixFile);
		//System.out.println("--------------> file csv name : "+s);
		try {
			br = new BufferedReader(new InputStreamReader(APmatrixFile));
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
					if (data.length == 8) {

						ApprovalMatrix amx = new ApprovalMatrix();
						amx.setTower(data[0]);
						amx.setRequest_Type(data[1]);
						amx.setStation(data[2]);
						amx.setDept(data[3]);
						amx.setMinimum_Limit(Integer.parseInt(data[4]));
						amx.setMaximum_Limit(Integer.parseInt(data[5]));
						amx.setStatus(data[6]);
						amx.setApproval_Id(data[7]);
						amx.setApproval_Level(Integer.parseInt(data[8]));
						System.out.println(amx.getApproval_Id());
						apMatrix.save(amx);
						System.out.println("  Approval matrix ------> DB ");
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
			File amxFILE = new File("./src/main/resources/ERR_"+s);
			FileWriter writer = new FileWriter(amxFILE);
			String collect = test.stream().collect(Collectors.joining("\n"));
			writer.write(collect);
			writer.close();
			sftpChannel.put("./src/main/resources/ERR_"+s,sftpChannel.pwd()+"error1/"+s);
			System.out.println("  Approval matrix ------>ERR! folder ");
			amxFILE.delete();

			}
			}
		
	}
	
}
