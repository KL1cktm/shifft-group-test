package by.korona.sub.model;

import lombok.Data;

@Data
public class User implements Observer {
    private Long id;
    private String username;
}
