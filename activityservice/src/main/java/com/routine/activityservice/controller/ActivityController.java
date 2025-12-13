package com.routine.activityservice.controller;

import com.routine.activityservice.dto.ActivityRequest;
import com.routine.activityservice.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<Object> trackActivity(@RequestBody ActivityRequest request){
        try{
            return ResponseEntity.ok(activityService.trackActivity(request));
        } catch (Exception e) {
            HashMap<String,Object> jsonString = new HashMap<String,Object>();
            jsonString.put("error",e.getMessage());
            return ResponseEntity.ok(jsonString);
        }
    }
}
