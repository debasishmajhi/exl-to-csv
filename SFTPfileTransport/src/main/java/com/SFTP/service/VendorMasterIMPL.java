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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SFTP.Entity.VendorMaster;
import com.SFTP.Persistance.VendorMasterJPA;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

@Service
public class VendorMasterIMPL {

	@Autowired
	private VendorMasterJPA VendorMasterJPA;
	
	BufferedReader br;
	List<String> test = new ArrayList<>();
	String file_data_exc = "";
	
	public void Vendor_masterIMPL(InputStream VenderStream,String s,ChannelSftp sftpChannel) throws SftpException, IOException {
		
		try {
			br = new BufferedReader(new InputStreamReader(VenderStream));
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
					System.out.println(data.length);
					if (data.length == 18) {
						
						VendorMaster vendorMaster = new VendorMaster();
						vendorMaster.setERPID(data[0]);
						vendorMaster.setSupplier_ID(Integer.parseInt(data[1]));
						vendorMaster.setSupplierName(data[2]);
						vendorMaster.setEnabled_flag(data[3]);
						vendorMaster.setTerm_id(Integer.parseInt(data[4]));
						vendorMaster.setInvoice_cuntry_code(data[5]);
						vendorMaster.setPayment_cuntry_code(data[6]);
						vendorMaster.setStart_date_active(new SimpleDateFormat("dd-MM-yyyy").parse(data[7]));
						vendorMaster.setEnd_date_start(new SimpleDateFormat("dd-MM-yyyy").parse(data[8]));
						vendorMaster.setPament_method(data[9]);
						vendorMaster.setAddress_line1(data[10]);
						vendorMaster.setAddress_line2(data[11]);
						vendorMaster.setAddress_line3(data[12]);
						vendorMaster.setCity(data[13]);
						vendorMaster.setState(data[14]);
						vendorMaster.setZip(data[15]);
						vendorMaster.setCountry(data[16]);
						vendorMaster.setRemittance_email(data[17]);
						VendorMasterJPA.save(vendorMaster);
						System.out.println(" vender master ------> DB ");
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
			File vmFILE = new File("./src/main/resources/ERR_"+s);
			FileWriter writer = new FileWriter(vmFILE);
			String collect = test.stream().collect(Collectors.joining("\n"));
			writer.write(collect);
			writer.close();
			System.out.println("  vender master "+s);
			sftpChannel.put("./src/main/resources/ERR_"+s,sftpChannel.pwd()+"error1/"+s);
			System.out.println("  vender master ------> err1 ");
			vmFILE.delete();
			}
		}
	}
}
