package by.korona.communicationform.dto;

import java.time.LocalDateTime;

public record Message(LocalDateTime creationTime, String name, String message) {
}
