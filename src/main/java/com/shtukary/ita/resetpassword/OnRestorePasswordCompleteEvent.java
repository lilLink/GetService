package com.shtukary.ita.resetpassword;

import com.shtukary.ita.model.User;
import org.springframework.context.ApplicationEvent;

@SuppressWarnings("restorepassword")
public class OnRestorePasswordCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final User user;

    public OnRestorePasswordCompleteEvent(final User user, final String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public User getUser() {
        return user;
    }

}
