package com.routine.aiservice.controller;

import com.routine.aiservice.model.Recommendation;
import com.routine.aiservice.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping("/user/{userId}")
    public Object getUserRecommendation(@PathVariable String userId){
        try{
            return ResponseEntity.ok(recommendationService.getUserRecommendation(userId));
        } catch (Exception e) {
            HashMap<String,Object> jsonString = new HashMap<String,Object>();
            jsonString.put("error",e.getMessage());
            return ResponseEntity.ok(jsonString);
        }
    }

    @GetMapping("/activity/{activityId}")
    public Object getActivityRecommendation(@PathVariable String activityId){
        try{
            return ResponseEntity.ok(recommendationService.getActivityRecommendation(activityId));
        } catch (Exception e) {
            HashMap<String,Object> jsonString = new HashMap<String,Object>();
            jsonString.put("error",e.getMessage());
            return ResponseEntity.ok(jsonString);
        }
    }

}
