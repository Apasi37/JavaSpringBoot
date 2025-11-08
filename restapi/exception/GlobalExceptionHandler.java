package sk.ukf.restapi.exception;


import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler {
    /*
    // Validačné chyby
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<String>>> handleValidation(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.add(error.getDefaultMessage())
        );

        ApiResponse<List<String>> response = new ApiResponse<>(errors, "Validačné chyby", LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }

    // Ostatné chyby
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error("Nastala chyba: " + ex.getMessage(), LocalDateTime.now()));
    }

    // Objekt nenájdený - genericky pre všetky entity
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleObjectNotFound(ObjectNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(ex.getMessage(), LocalDateTime.now()));
    }

    // Email už existuje
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<String>> handleEmailExists(EmailAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.error(ex.getMessage(), LocalDateTime.now()));
    }
    */

    @ExceptionHandler(ObjectNotFoundException.class)
    public String handleObjectNotFound(ObjectNotFoundException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "templates/error/not-found";
    }

    // Ostatné chyby
    @ExceptionHandler(Exception.class)
    public String handleGeneral(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "templates/error/server-error";
    }
}
