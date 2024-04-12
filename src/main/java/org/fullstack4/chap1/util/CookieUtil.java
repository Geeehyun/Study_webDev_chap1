package org.fullstack4.chap1.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void setCookie(HttpServletResponse resp, String name, String value, int expire_date) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(expire_date);
        resp.addCookie(cookie);
    }
    public static String getCookieValue(HttpServletRequest req, String name) {
        String value = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            String cookieVal = cookie.getValue();
            if (name.equals(cookieName)) {
                value = cookieVal;
                break;
            }
        }
        return value;
    }

    public static void deleteCookie(HttpServletResponse resp, String name) {
        setCookie(resp, name, "", 0);
    }
}
