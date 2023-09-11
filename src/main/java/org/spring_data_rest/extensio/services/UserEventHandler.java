package org.spring_data_rest.extensio.services;

import lombok.RequiredArgsConstructor;
import org.spring_data_rest.extensio.domain.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

// TODO,FIXME: This class should be replaced with battery
@Service
@RepositoryEventHandler
@RequiredArgsConstructor
public class UserEventHandler {

    // Note - it is only invoked by Spring Data REST
    @HandleBeforeCreate
    @HandleBeforeSave
    public void handleProjectBeforeCreateSave(User user) {
        if (null != user.getAttributes()) {
            user.getAttributes().forEach(it -> it.setUser(user));
        }
    }
}
