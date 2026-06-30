package app.web;

import app.model.dto.barbershop.BarbershopLoginRequest;
import app.model.dto.barbershop.BarbershopRegisterRequest;
import app.service.barbershop.BarbershopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    private final BarbershopService barbershopService;

    @Autowired
    public IndexController(BarbershopService barbershopService) {
        this.barbershopService = barbershopService;
    }

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        BarbershopRegisterRequest barbershopRegisterRequest = BarbershopRegisterRequest.builder().build();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("barbershopRegisterRequest",barbershopRegisterRequest);

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute BarbershopRegisterRequest barbershopRegisterRequest, BindingResult bindingResult) {
        barbershopService.register(barbershopRegisterRequest);

        if(bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("register");
            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        BarbershopLoginRequest barbershopLoginRequest = BarbershopLoginRequest.builder().build();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("barbershopLoginRequest",barbershopLoginRequest);

        return modelAndView;
    }
}
