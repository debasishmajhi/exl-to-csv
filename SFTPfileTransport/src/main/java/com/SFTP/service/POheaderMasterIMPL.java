package com.SFTP.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SFTP.Entity.PoHeader_Master;
import com.SFTP.Persistance.POheaderMasterJPA;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

@Service
public class POheaderMasterIMPL {

	@Autowired
	private POheaderMasterJPA POmasterJPA;
	
	BufferedReader br;
	List<String> test = new ArrayList<>();
	String file_data_exc = "";
	
	public void Po_headerIMPL(InputStream PO_Stream,String s,ChannelSftp sftpChannel) throws SftpException, IOException{
		try {
			br = new BufferedReader(new InputStreamReader(PO_Stream));
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
					System.out.println(data[0]);
					if (data.length == 13) {
						
						PoHeader_Master poMaster = new PoHeader_Master();
						System.out.println("obj created");
						poMaster.setERPID(data[0]);
						System.out.println("set 0");
						poMaster.setCompanyCode(data[1]);
						System.out.println("sett 1");
						poMaster.setBusinessUnitID(data[2]);
						System.out.println("setting 2");
						poMaster.setPoNumber(data[3]);
						System.out.println("setting 3");
						poMaster.setPoDate(new SimpleDateFormat("dd-MM-yyyy").parse(data[4]));
						System.out.println("setting 4");
						poMaster.setPoStatus(data[5].charAt(0));
						System.out.println("setting 5");
						poMaster.setPaymentTerms(data[6]);
						System.out.println("setting 6");
						poMaster.setPaymentTermDescription(data[7]);
						System.out.println("setting 7");
						poMaster.setTermsAbsoluteNumber(Integer.parseInt(data[8]));
						System.out.println("setting 8");
						poMaster.setCurrency(data[9]);
						System.out.println("setting 9");
						poMaster.setPoTotal(Integer.parseInt(data[10]));
						System.out.println("setting 10");
						poMaster.setPoRequester(data[11]);
						System.out.println("setting 11");
						poMaster.setVendorID(data[12]);
						System.out.println("setting 12");
						POmasterJPA.save(poMaster);
						System.out.println("  poheader ------> DB ");
					} else {
							test.add(file_data);	
					}
				}

			}
		} catch (Exception e) {
			test.add(file_data_exc);
		}
		finally {
			try {
			if(!test.isEmpty()) {
				File poFILE = new File("./src/main/resources/ERR_"+s);
				System.out.println("file created in local "+s);
				FileWriter writer = new FileWriter(poFILE);
				String collect = test.stream().collect(Collectors.joining("\n"));
				writer.write(collect);
				System.out.println("data entered into "+s);
				writer.close();
				System.out.println("weritting close");
				sftpChannel.put("./src/main/resources/ERR_"+s,sftpChannel.pwd()+"error1/"+s);
				System.out.println("  poheader ------> err1 ");
				poFILE.delete();
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
	

