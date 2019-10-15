package utils;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HTTPUtils {
	private HTTPUtils() {
		throw new IllegalAccessError("Can not create a new instance of this class");
	}
	public static HttpSession getCurrentSession(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true);
	}
		
}
