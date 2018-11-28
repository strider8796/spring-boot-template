package com.example.demo.repositories;

import com.example.demo.models.WebLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebLogRepository  extends JpaRepository<WebLog, Long> {
}
