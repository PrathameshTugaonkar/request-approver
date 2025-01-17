package com.example.approverapp.repository;

import com.example.approverapp.model.ApprovalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest, Long> {
}