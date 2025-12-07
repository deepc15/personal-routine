package com.routine.activityservice.service;

import com.routine.activityservice.dto.ActivityRequest;
import com.routine.activityservice.dto.ActivityResponse;
import com.routine.activityservice.model.Activity;
import com.routine.activityservice.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity = Activity.builder().userId(request.getUserId()).type(request.getType())
                .duration(request.getDuration())
                .pattern(request.getPattern())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();
        Activity savedActivity = activityRepository.save(activity);
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setType(activity.getType());
        response.setUserId(activity.getUserId());
        response.setDuration(activity.getDuration());
        response.setPattern(activity.getPattern());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return response;
    }
}
