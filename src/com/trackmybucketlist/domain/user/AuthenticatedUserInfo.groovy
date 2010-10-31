package com.trackmybucketlist.domain.user

class AuthenticatedUserInfo implements UserInfo {
    final boolean loggedIn = true
    String url
    String email
    String nickname

    boolean isLoggedIn() {
        loggedIn
    }

    String getUrl() {
        url
    }

    @Override
    public String toString() {
        return "AuthenticatedUserInfo{" +
               "loggedIn=" + loggedIn +
               ", url='" + url + '\'' +
               ", email='" + email + '\'' +
               ", nickname='" + nickname + '\'' +
               '}' ;
    }
}
