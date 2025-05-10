package by.korona.sub.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User implements Observer {
    private Long id;
    private String username;
}
