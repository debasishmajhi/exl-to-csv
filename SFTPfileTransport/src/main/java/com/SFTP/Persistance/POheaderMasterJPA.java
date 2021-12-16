package com.SFTP.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SFTP.Entity.PoHeader_Master;

public interface POheaderMasterJPA extends JpaRepository<PoHeader_Master, String>{

}
