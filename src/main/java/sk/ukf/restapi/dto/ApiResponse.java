package sk.ukf.restapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import sk.ukf.restapi.entity.Employee;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private String message;
    private T data;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateTime;

    public ApiResponse(T data, String message, LocalDateTime dateTime) {
        this.data = data;
        this.message = message;
        this.dateTime = dateTime;
    }

    // Jednoduché statické metódy
    public static <T> ApiResponse<T> success(T data, LocalDateTime dateTime) {
        return new ApiResponse<>(data, null, dateTime);
    }

    public static <T> ApiResponse<T> success(T data, String message, LocalDateTime dateTime) {
        return new ApiResponse<>(data, message, dateTime);
    }

    public static <T> ApiResponse<T> success(String message, LocalDateTime dateTime) {
        return new ApiResponse<>(null, message, dateTime);
    }

    public static <T> ApiResponse<T> error(String message, LocalDateTime dateTime) {
        return new ApiResponse<>(null, message, dateTime);
    }

    // Gettery a settery
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
