package spring.core.boot.main;

//import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.core.boot.model.Role;
import spring.core.boot.model.Users;
import spring.core.boot.repo.RoleRepo;
import spring.core.boot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	
	@Autowired
	private RoleRepo rolerepo;
	
	@ModelAttribute("userForm")
	public Users create()
	{
		return new Users();
	}
		
	@GetMapping("/registration")
	public ModelAndView register(Model model) {
		//model.addAttribute("userForm", new Users());
		List<Role> roles= rolerepo.findAll();		
        //return "registration";
		//List<String> names=new ArrayList<String>() ;
		//for(int i=0;i<roles.size();i++) {
		//	names.add(roles.get(i).getRole());
		//}
		return new ModelAndView("/registration","radio",roles);
	}
	
	@PostMapping("/registration")
	public String registerup(@ModelAttribute("userForm") Users userForm,Model model)
	{
		userservice.save(userForm);
		return "redirect:/login";
	}
	
	@GetMapping("index")
	public String index() {
		

        return "index";
	}
	
	@PreAuthorize("hasAnyRole('LIB')")
	@GetMapping("/library")
	public String lib() {
		

        return "library";
	}
	
	@PreAuthorize("hasAnyRole('PIR')")
	@GetMapping("/principle")
	public String pir() {
		

        return "principle";
	}
    
    
	@GetMapping("/login")
	public String login() {
		

        return "login";
	}
	
	@GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
