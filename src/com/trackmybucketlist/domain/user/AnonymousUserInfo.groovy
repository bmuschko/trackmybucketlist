package com.trackmybucketlist.domain.user

class AnonymousUserInfo implements UserInfo {
    final boolean loggedIn = false
    String url

    boolean isLoggedIn() {
        loggedIn
    }

    String getUrl() {
        url
    }

    @Override
    public String toString() {
        return "AnonymousUserInfo{" +
               "loggedIn=" + loggedIn +
               ", url='" + url + '\'' +
               '}' ;
    }
}
