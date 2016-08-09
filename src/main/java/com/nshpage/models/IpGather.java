package com.nshpage.models;

import javax.servlet.http.HttpServletRequest;


public class IpGather {
	
	public String ip(HttpServletRequest req) {
		//HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

        String ip = req.getHeader("X-FORWARDED-FOR");

        if (ip == null)
            ip = req.getRemoteAddr();
        
        return ip;
	}
}
