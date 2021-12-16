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

import com.SFTP.Entity.HRheirarchyMaster;
import com.SFTP.Persistance.HRheirarchyMasterJPA;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;





@Service
public class HRheirarchyMasterIMPL {

	@Autowired
	private HRheirarchyMasterJPA HRmasterJPA;
	BufferedReader br;
	List<String> test = new ArrayList<>();
	String file_data_exc = "";
	
	public void HR_masterIMPL(InputStream HRmaster,String s,ChannelSftp sftpChannel) throws SftpException, IOException {
		try {
			br = new BufferedReader(new InputStreamReader(HRmaster));
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
					System.out.println(data[1]);
					if (data.length == 12) {

						HRheirarchyMaster hrMaster = new HRheirarchyMaster();
						hrMaster.setERPID(data[0]);
						hrMaster.setTower(data[1]);
						hrMaster.setBU(data[2]);
						hrMaster.setUserId(data[3]);
						hrMaster.setFirstName(data[4]);
						hrMaster.setLastNme(data[5]);
						hrMaster.setEmailID(data[6]);
						hrMaster.setUserStatus(data[7]);
						hrMaster.setSupervisorEscalatonID(data[8]);
						hrMaster.setSupervisorEmailID(data[9]);
						hrMaster.setUserRole(data[10]);
						hrMaster.setUserRoleStatus(data[11]);
						HRmasterJPA.save(hrMaster);

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
			File hrFILE = new File("./src/main/resources/ERR_"+s);
			FileWriter writer = new FileWriter(hrFILE);
			String collect = test.stream().collect(Collectors.joining("\n"));
			writer.write(collect);
			writer.close();
			sftpChannel.put("./src/main/resources/ERR_"+s,sftpChannel.pwd()+"error1/"+s);
			hrFILE.delete();
			}
		}
	}
	
}
