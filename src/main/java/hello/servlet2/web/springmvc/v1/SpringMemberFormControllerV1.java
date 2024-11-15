package hello.servlet2.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //스프링이 자동으로 스프링 빈으로 등록함, 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식
public class SpringMemberFormControllerV1 {

    //해당 URL이 호출되면 이 메서드가 호출된다, 메서드의 이름은 임의로 지어도 됨
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
