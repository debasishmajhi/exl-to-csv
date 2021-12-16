package com.SFTP.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SFTP.Entity.ApprovalMatrix;


@Repository
public interface ApMatrixJPA extends JpaRepository<ApprovalMatrix, String>{

}
