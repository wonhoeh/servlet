package hello.servlet2.web.springmvc.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;

/**
 * 1. 핸들러 매핑으로 핸들러 조회; HandlerMapping = BeanNameUrlHandlerMapping
 * 2. 핸들러 어댑터 조회; HandlerAdapter = HttpRequestHandlerAdapter
 */
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handlerRequest");
    }
}
