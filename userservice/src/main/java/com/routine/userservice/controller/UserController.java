package com.routine.userservice.controller;

import com.routine.userservice.dto.RegisterRequest;
import com.routine.userservice.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/fetch-user/{userId}")
    public ResponseEntity<Object> fetchUser(@PathVariable String userId) throws Exception{
        try{
            return ResponseEntity.ok(userService.getUserProfile(userId));
        } catch (Exception e) {
            HashMap<String,Object> jsonString = new HashMap<String,Object>();
            jsonString.put("error",e.getMessage());
            return ResponseEntity.ok(jsonString);
        }
    }

    @GetMapping("/fetch-user/{userId}/validate")
    public ResponseEntity<Object> validateUser(@PathVariable String userId) throws Exception{
        try{
            return ResponseEntity.ok(userService.existByUserId(userId));
        } catch (Exception e) {
            HashMap<String,Object> jsonString = new HashMap<String,Object>();
            jsonString.put("error",e.getMessage());
            return ResponseEntity.ok(jsonString);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterRequest request) throws Exception{
        try{
            return ResponseEntity.ok(userService.register(request));
        } catch (Exception e) {
            HashMap<String,Object> jsonString = new HashMap<String,Object>();
            jsonString.put("error",e.getMessage());
            return ResponseEntity.ok(jsonString);
        }
    }
}
