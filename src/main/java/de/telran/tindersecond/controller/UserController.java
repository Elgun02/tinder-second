package de.telran.tindersecond.controller;

import de.telran.tindersecond.entity.User;
import de.telran.tindersecond.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //создается контроллер и управляется спрингом
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/show-new-user")
    public User showNewUser() {
        return userService.getNewUser();
    }

    @GetMapping(value = "/autocomplete/{name}")
    public List<User> getByName(@PathVariable(value = "name") String name) {
        return userService.getByName(name);
    }

    @GetMapping(value = "/show-users-between/{min_rating}/{max_rating}")
    public List<User> getUsersRatingBetween(
            @PathVariable(value = "min_rating") Integer min_rating, @PathVariable(value = "max_rating") Integer max_rating) {
        return userService.getBetweenRating(min_rating, max_rating);

    }

    @GetMapping(value = "/show-users-description-like/{value}")
    public List<User> getUsersDescriptionContain(@PathVariable(value = "value") String value) {
        return userService.getByDescriptionContaining(value);
    }

    @GetMapping(value = "/find-user/{id}")
    public boolean findUserContainingId(@PathVariable(value = "id") Long id) {
        return userService.findUserContainingId(id);
    }

    @GetMapping(value = "/show-users/{page}/{size}")
    public List<User> getAllUserWithPagination(@PathVariable(value = "page") Integer page, @PathVariable(value = "size") Integer size) {
        return userService.getAllUsers(page, size);
    }

}
