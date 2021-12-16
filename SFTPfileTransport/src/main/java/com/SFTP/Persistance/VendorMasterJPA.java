package com.SFTP.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SFTP.Entity.VendorMaster;

public interface VendorMasterJPA extends JpaRepository<VendorMaster, String>{

}
