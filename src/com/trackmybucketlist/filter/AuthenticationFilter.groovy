package com.trackmybucketlist.filter

import com.google.appengine.api.users.User
import com.google.appengine.api.users.UserService
import com.google.appengine.api.users.UserServiceFactory
import com.trackmybucketlist.domain.user.AnonymousUserInfo
import com.trackmybucketlist.domain.user.AuthenticatedUserInfo
import com.trackmybucketlist.domain.user.UserInfo
import groovyx.gaelyk.logging.GroovyLogger
import javax.servlet.http.HttpServletRequest
import javax.servlet.*

class AuthenticationFilter implements Filter {
    private final String LOGOUT_URL = "/"
    private final String LOGIN_URL = "/user/goals"
    private GroovyLogger log

    void init(FilterConfig filterConfig) {
        this.log = new GroovyLogger('com.trackmybucketlist.AuthenticationFilter')
    }

    void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest request = (HttpServletRequest)servletRequest

        UserService userService = UserServiceFactory.getUserService()
        User user = userService.getCurrentUser()
        def requestURI = request.requestURI

        UserInfo userInfo

        if(user) {
            userInfo = new AuthenticatedUserInfo()
            userInfo.setUrl userService.createLogoutURL(LOGOUT_URL)
            userInfo.setUserId user.getUserId()
            userInfo.setNickname user.getNickname()
            userInfo.setEmail user.getEmail()
        }
        else {
            userInfo = new AnonymousUserInfo()
            userInfo.setUrl userService.createLoginURL(LOGIN_URL)
        }

        log.info "Current login information: ${userInfo} for requested URI '${requestURI}'"
        request.setAttribute "userInfo", userInfo
        filterChain.doFilter servletRequest, servletResponse
    }

    void destroy() {
    }
}



