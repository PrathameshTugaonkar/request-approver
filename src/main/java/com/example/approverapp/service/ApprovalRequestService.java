
package com.example.approverapp.service;

import com.example.approverapp.dto.ApprovalRequestDTO;
import com.example.approverapp.model.ApprovalRequest;
import com.example.approverapp.model.ApprovalStatus;
import com.example.approverapp.repository.ApprovalRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalRequestService {
    private final ApprovalRequestRepository repository;

    public List<ApprovalRequest> getAllRequests() {
        return repository.findAll();
    }

    public ApprovalRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Approval request not found"));
    }

    @Transactional
    public ApprovalRequest createRequest(ApprovalRequestDTO dto) {
        ApprovalRequest request = new ApprovalRequest();
        request.setApplicationName(dto.getApplicationName());
        request.setVersion(dto.getVersion());
        request.setRequestedBy(dto.getRequestedBy());
        request.setStatus(ApprovalStatus.PENDING);
        return repository.save(request);
    }

    @Transactional
    public ApprovalRequest updateRequestStatus(Long id, ApprovalStatus status, String comments) {
        ApprovalRequest request = getRequestById(id);
        request.setStatus(status);
        request.setApproverComments(comments);
        return repository.save(request);
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}