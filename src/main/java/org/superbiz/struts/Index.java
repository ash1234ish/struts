package org.superbiz.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;

@Component
public class Index extends ActionSupport {
    private UserService userService;

    public Index(UserService userService) {
        this.userService = userService;
    }
}
