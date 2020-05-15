package com.lldt.springcloud.fresh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class TokenFilter extends ZuulFilter{

	/**
	 * 过滤类型：
	 * 四种类型：pre,routing,error,post
	 * pre:主要用在路由阶段的寻找映射表的
	 * rousting：具体的路由转发过滤器在routing路由器，具体的请求转发的时候会调用
	 * error：一旦前面的过滤器出错了，会调用error过滤器
	 * post：当routing，error运行完之后才会调用该过滤器在最后阶段的
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	
	/**
	 * 过滤器是否生效
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	

	
	/**
	 * 自定义过滤器的顺序，数值越大靠后执行，越小越先执行
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
	
	
	/**
	 * 执行过滤逻辑
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		/*RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		HttpServletResponse response = context.getResponse();
		
		String token = request.getParameter("token");
		if(token == null || "".contentEquals(token)) {
			response.setCharacterEncoding("text/html;charset=utf-8");
			context.setRequest(request);
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			context.setResponseBody("权限不足");
			return null;
		}*/
		return null;
	
	}
}
