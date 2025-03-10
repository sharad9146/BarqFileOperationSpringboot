package com.example.BarqFileOperation.Repository;

import com.example.BarqFileOperation.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
}