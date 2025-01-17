package com.example.approverapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalRequestDTO {
    @NotBlank(message = "Application name is required")
    private String applicationName;

    @NotBlank(message = "Version is required")
    private String version;

    @NotBlank(message = "Requester name is required")
    private String requestedBy;

    private String approverComments;
}