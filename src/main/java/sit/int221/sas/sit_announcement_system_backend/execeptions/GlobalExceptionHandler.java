package sit.int221.sas.sit_announcement_system_backend.execeptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorResponse>  handlerAuthentication(RuntimeException e){
//        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        ErrorResponse er = new ErrorResponse(LocalDateTime.now().format(formatter),HttpStatus.NOT_FOUND.value(),e.getMessage(), e.getMessage().getClass().getSimpleName());
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er) ;
//    }
}
