package de.telran.tindersecond;


import lombok.AllArgsConstructor;
import lombok.Data;

//POJO - plain old java object - старый добрый джава объект
@Data //getter + setter + required args + to string + equals
@AllArgsConstructor //конструктор со всеми полями
public class User {

    private final long id;

    private String name;

    private int rating;

    private String description;

}
