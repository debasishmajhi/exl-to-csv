package com.SFTP.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SFTP.Entity.GLcodeMaster;

@Repository
public interface GLcodeMasterJPA extends JpaRepository<GLcodeMaster, String>{

}
