package com.routine.activityservice.dto;

import com.routine.activityservice.model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRequest {
    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private String pattern;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetrics;
}
