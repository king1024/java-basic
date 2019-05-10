package com.king.spring1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.king.spring1.model.SysUser;

/**
 * @author duanyong
 * 2019年4月11日 上午8:47:43
 */
@Component
@WebFilter(urlPatterns = "/",filterName = "blosTest")
public class LoginTestFilter implements Filter{

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        String url =request.getRequestURI();
        System.out.println("Filter============================="+url);
        if(url.equals("/loginPage") ||url.equals("/sys_user/login") 
        		|| url.endsWith(".js")	|| url.endsWith(".ico")	|| url.endsWith(".png")	|| url.endsWith(".css")	
        		|| url.endsWith(".jpg")	|| url.endsWith(".jpeg")	
        		) {
        	chain.doFilter(request,response);
        	return;
        }
        if(user==null) {
        	response.sendRedirect("/loginPage");
        }else {
        	chain.doFilter(request,response);
        }
	}
	
}
