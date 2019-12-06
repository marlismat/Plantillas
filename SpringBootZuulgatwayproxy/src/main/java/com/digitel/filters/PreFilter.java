package com.digitel.filters;
import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
 
public class PreFilter extends ZuulFilter {
 
  @Override
  public String filterType() {
	  System.out.println("pre-filterType");
    return "pre";
  }
 
  @Override
  public int filterOrder() {
	  System.out.println("pre-filterOrder");
    return 1;
  }
 
  @Override
  public boolean shouldFilter() {
	  System.out.println("pre-shouldFilter");
    return true;
  }
 
  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
 System.out.println("pre-run");
    System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
    return null;
  }
}