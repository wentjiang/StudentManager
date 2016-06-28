
package com.wentjiang.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 下午3:12:02 
*/
public class SuperAction extends ActionSupport implements ServletContextAware,ServletRequestAware,ServletResponseAware{
	private static final long serialVersionUID = 1L;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected ServletContext application;
	protected HttpSession session;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}


}
