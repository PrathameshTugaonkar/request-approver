
package com.example.approverapp.controller;

import com.example.approverapp.dto.ApprovalRequestDTO;
import com.example.approverapp.model.ApprovalRequest;
import com.example.approverapp.model.ApprovalStatus;
import com.example.approverapp.service.ApprovalRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approvals")

public class ApprovalRequestController {
    private final ApprovalRequestService service;


    // Constructor injection
    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ApprovalRequest>> getAllRequests() {
        return ResponseEntity.ok(service.getAllRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApprovalRequest> getRequestById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRequestById(id));
    }

    @PostMapping
    public ResponseEntity<ApprovalRequest> createRequest(@Valid @RequestBody ApprovalRequestDTO dto) {
        return ResponseEntity.ok(service.createRequest(dto));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ApprovalRequest> updateRequestStatus(
            @PathVariable Long id,
            @RequestParam ApprovalStatus status,
            @RequestParam(required = false) String comments) {
        return ResponseEntity.ok(service.updateRequestStatus(id, status, comments));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}