package entity;

import lombok.Data;

@Data
public class Student {
    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;

}
