package hello.servlet2.web.springmvc.v3;

import hello.servlet2.domain.member.Member;
import hello.servlet2.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 실무에서 주로 사용하는 방식
 * Model 도입 -> ModelAndView 귀찮게 생성안해도 됨
 * ViewName 직접 반환 -> 논리 이름만 반환하면 뷰 리졸버로 물리 이름으로 변환시켜서 랜더링
 *
 * @RequestParam 사용 -> request.getParameter("username") 이걸 애너테이션으로 간편화시킴, HTTP 요청 파라미터를 @RequestParam으로 받음
 * @RequestMapping 에서 @GetMapping, @PostMapping 사용 ->HTTP 메서드도 구분가능
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
