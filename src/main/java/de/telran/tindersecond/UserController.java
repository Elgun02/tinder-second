package de.telran.tindersecond;

import de.telran.tindersecond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //создается контроллер и управляется спрингом
public class UserController {
    
    private final UserService userService;

    public UserController(@Autowired @Qualifier(value = "randomUserService") UserService userService) { //Находит userService в контексте приложения и внедряет зависимость (заполняет переменную)
        this.userService = userService;
    }

    @GetMapping(value = "/show-new-user")
    public User showNewUser() {
        return userService.getNewUser();
    }

}
