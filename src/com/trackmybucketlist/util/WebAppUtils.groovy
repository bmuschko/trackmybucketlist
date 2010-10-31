package com.trackmybucketlist.util

import java.util.regex.Pattern
import javax.servlet.http.HttpServletRequest

final class WebAppUtils {
    private WebAppUtils() {
    }

    public static String getPathWithinApplication(HttpServletRequest request) {
          String contextPath = getContextPath(request)
          String requestUri = request.getRequestURI()
          if(StringUtils.startsWithIgnoreCase(requestUri, contextPath)) {
              // Normal case: URI contains context path.
              String path = requestUri.substring(contextPath.length())
              return (StringUtils.hasText(path) ? path : "/")
          }
          else {
              // Special case: rather unusual.
              return requestUri
          }
    }

    public static getContextPath(HttpServletRequest request) {
        String contextPath

        if(contextPath == null) {
            contextPath = request.getContextPath();
        }

        if ("/".equals(contextPath)) {
            // Invalid case, but happens for includes on Jetty: silently adapt it.
            contextPath = ""
        }

        contextPath
    }

    public static boolean matchesUrl(String compareUrl, String requestedUrl) {
        String uriPattern = compareUrl.replaceAll("\\*", ".*");
        Pattern.matches(uriPattern, requestedUrl)
    }

    public static boolean matchesUrls(Collection<String> compareUrls, String requestedUrl) {
        for(String compareUrl : compareUrls) {
            if(matchesUrl(compareUrl, requestedUrl)) {
                return true
            }
        }

        return false
    }
}
