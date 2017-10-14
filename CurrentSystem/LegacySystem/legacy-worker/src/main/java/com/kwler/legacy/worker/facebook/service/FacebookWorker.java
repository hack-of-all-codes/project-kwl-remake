package com.kwler.legacy.worker.facebook.service;

import com.kwler.legacy.worker.facebook.model.UsernameResolverRequest;
import com.kwler.legacy.worker.facebook.model.UsernameResolverResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;

@Service
@Log
public class FacebookWorker {

    @Autowired
    Facebook facebook;

    @SqsListener("${app.aws.queue.facebook.username.request}")
    @SendTo("${app.aws.queue.facebook.username.result}")
    public UsernameResolverResponse resolveUsername(UsernameResolverRequest request) {
        try {
            User user = facebook.userOperations().getUserProfile(request.getId());
            return UsernameResolverResponse.builder()
                    .id(request.getId())
                    .username(user.getName())
                    .success(true)
                    .build();
        } catch (Exception e) {
            return UsernameResolverResponse.builder()
                    .id(request.getId())
                    .success(false)
                    .errorMessage(e.getMessage())
                    .build();
        }
    }

}
