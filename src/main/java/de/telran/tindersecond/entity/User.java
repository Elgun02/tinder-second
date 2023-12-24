package de.telran.tindersecond.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//POJO - Plain Old Java Object - Старый добрый джава объект
@Entity                  // Сущность JPA
@Table(name = "account") // Название таблицы
@Data                    // Getter + Setter + Required args + ToString + Equals
@AllArgsConstructor      // Конструктор со всеми полями
@NoArgsConstructor       // Коснтруктор без полей
public class User {

    @Id                  // Поле уникальности + Primary Key
    @Column(name = "id") // Именование столбца в бд
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private int rating;

    @Column(name = "description")
    private String description;

}
