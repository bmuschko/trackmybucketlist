package com.trackmybucketlist.util

final class StringUtils {
    private StringUtils() {
    }

    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str == null || prefix == null) {
            return false;
        }
        if (str.startsWith(prefix)) {
            return true;
        }
        if (str.length() < prefix.length()) {
            return false;
        }
        String lcStr = str.substring(0, prefix.length()).toLowerCase();
        String lcPrefix = prefix.toLowerCase();
        return lcStr.equals(lcPrefix);
    }

    public static boolean hasText(String str) {
       int strLen;
       if (str == null || (strLen = str.length()) == 0) {
           return false;
       }
       for (int i = 0; i < strLen; i++) {
           if (!Character.isWhitespace(str.charAt(i))) {
               return true;
           }
       }
       return false;
    }  
}
