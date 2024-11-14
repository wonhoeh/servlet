package hello.servlet2.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * /springmvc/old-controller 라는 이름의 스프링 빈으로 등록됨
 * 1. 핸들러 매핑으로 핸들러 조회: 스프링 빈의 이름으로 찾는 핸들러인 BeanNameUrlHandlerMapping이 실행됨
 * 2. 핸들러 어댑터 조회: SimpleControllerHandlerAdapter가 Controller 인터페이스를 지원하므로 이게 실행됨
 * 3. 핸들러 어댑터 실행: SimpleControllerHandlerAdapter를 실행하면서 핸들러 정보를 넘겨줌, 그리고 결과를 반환받음
 * HandlerMapping = BeanNameUrlHandlerMapping
 * HandlerAdapter = SimpleControllerHandlerAdapter
 */
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        /**
         * application.properties 추가할 내용
         * spring.mvc.view.prefix=/WEB-INF/views/
         * spring.mvc.view.suffix=.jsp
         * InternalResourceViewResolver 뷰 리졸버를 등록할 때 위의 속성값을 참고해서 등록함
         */
        return new ModelAndView("new-form");

    }
}
