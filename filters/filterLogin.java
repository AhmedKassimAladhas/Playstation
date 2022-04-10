package filters;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



/**
 * Servlet Filter implementation class filterLogin
 */
@WebFilter("/filterLogin")
//@SessionAttributes("name")
public class filterLogin implements Filter {

    /**
     * Default constructor. 
     */
    public filterLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestServlet = (HttpServletRequest) request;
		HttpServletResponse responseServlet = (HttpServletResponse) response;
		
		String uri = requestServlet.getRequestURI();
		String name = null;
		if(!uri.endsWith("hello") && !uri.endsWith("index") && !uri.endsWith("login")) {
			HttpSession session = requestServlet.getSession(true);														
			if(session != null) {
				name =  (String) session.getAttribute("name");	
				System.out.println("...." + name);
				if(name == null || name == "out") {
					
					responseServlet.sendRedirect("index");
				}
			}
		}
		 
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
