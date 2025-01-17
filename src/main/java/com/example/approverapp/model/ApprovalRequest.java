package com.example.approverapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "approval_requests")
public class ApprovalRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String applicationName;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private String requestedBy;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus status;

    private String approverComments;

    @Column(nullable = false)
    private LocalDateTime requestedAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        requestedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}