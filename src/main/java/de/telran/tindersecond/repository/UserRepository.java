package de.telran.tindersecond.repository;

import de.telran.tindersecond.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getUsersByNameStartingWithIgnoreCase(String name);

    @Query("SELECT new User(u.id, u.name, u.rating, u.description) from User u") // JPQL
    List<User> findAutocomplete3(@Param(value = "name") String name);

    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE name LIKE :name%") // SQL
    List<User> findAutocomplete2(@Param(value = "name") String name);

    // Homework
    // Задача 1.
    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE rating BETWEEN :minRating AND :maxRating") // SQL
    List<User> getUsersBetweenRating(@Param(value = "minRating") Integer minRating, @Param(value = "maxRating") Integer maxRating);

    // Задача 2.
    @Query("SELECT new User (player.id, player.name, player.rating, player.description) from User player WHERE player.description ILIKE %:description%") // JPQL
    List<User> getUsersByDescriptionContain(@Param(value = "description") String description);

    // Задача 3.
    User findUserById(Long id);

    // Задача 4. (2 уровень сложности)
    @Query(nativeQuery = true, value = "SELECT * FROM account OFFSET :page LIMIT :size")
    List<User> getAllUsers(Integer page, Integer size);

}
