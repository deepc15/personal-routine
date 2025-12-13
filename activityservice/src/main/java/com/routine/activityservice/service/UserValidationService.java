package com.routine.activityservice.service;

import com.routine.activityservice.config.WebClientConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService {
    public final WebClientConfig webClientConfig;
    public final WebClient.Builder webClientBuilder;

    public boolean validateUser(String userId){
        log.info("Calling User Service for {}", userId);
        try{
            return Boolean.TRUE.equals(webClientConfig.userServiceWebClient(webClientBuilder).get()
                    .uri("/api/users/fetch-user/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block());
        }catch (WebClientResponseException e){
            e.printStackTrace();
            return false;
        }

    }
}
