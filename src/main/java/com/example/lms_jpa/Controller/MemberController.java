package com.example.lms_jpa.Controller;

import com.example.lms_jpa.domain.Member;
import com.example.lms_jpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "members/createMemberForm";
    }
    @PostMapping("members/new")
    public String create(@Valid MemberForm memberForm, BindingResult result){

        if(result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setName(memberForm.getName());
        member.setUser_id(memberForm.getUser_id());

        memberService.join(member);

        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
    @GetMapping("members/login")
    public String createLoginForm(Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "members/login";
    }
    @PostMapping("members/login")
    public String logIn(@Valid LoginForm loginForm,BindingResult result){
        if(result.hasErrors()){
            return "redirect:/";
        }
        memberService.Login(loginForm.getUser_id(),loginForm.getPassword());
        return "redirect:/";
    }
}
