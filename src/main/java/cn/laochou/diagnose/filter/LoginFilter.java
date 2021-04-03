package cn.laochou.diagnose.filter;

import cn.laochou.diagnose.pojo.User;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登陆过滤
 * 所访问资源，必须登录，判断身份
 */
@Order(1)
@WebFilter(filterName = "loginFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "URL", value = "http://localhost:8080")
})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String uri = servletRequest.getRequestURI();
        if(uri.contains("js") || uri.contains("css") || uri.contains("html") || uri.equals("/user/login") || uri.equals("/diagnose/login") || uri.equals("/user/register") || uri.equals("/diagnose/register")) {
            chain.doFilter(request, response);
            return;
        }
        User user = (User) servletRequest.getSession().getAttribute("user");
        if(user == null) {
            request.getRequestDispatcher("/diagnose/login").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
