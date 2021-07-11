package com.desafio.desafiospring.exceptions;

import com.desafio.desafiospring.dto.exception.ExceptionDto;
import com.desafio.desafiospring.exceptions.products.DetailNotFound;
import com.desafio.desafiospring.exceptions.products.InvalidPrice;
import com.desafio.desafiospring.exceptions.products.PostNotAllowed;
import com.desafio.desafiospring.exceptions.products.PostNotFound;
import com.desafio.desafiospring.exceptions.user.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(SameUserToFollow.class)
    public ResponseEntity<ExceptionDto> defaultHandler(SameUserToFollow e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(UserAlreadyFollowing.class)
    public ResponseEntity<ExceptionDto> defaultHandler(UserAlreadyFollowing e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ExceptionDto> defaultHandler(UserNotFound e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(UserTypeNotDefined.class)
    public ResponseEntity<ExceptionDto> defaultHandler(UserTypeNotDefined e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(FollowNotAllowed.class)
    public ResponseEntity<ExceptionDto> defaultHandler(FollowNotAllowed e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(UserNotFollowing.class)
    public ResponseEntity<ExceptionDto> defaultHandler(UserNotFollowing e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(InvalidUserType.class)
    public ResponseEntity<ExceptionDto> defaultHandler(InvalidUserType e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(InvalidPrice.class)
    public ResponseEntity<ExceptionDto> defaultHandler(InvalidPrice e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(PostNotAllowed.class)
    public ResponseEntity<ExceptionDto> defaultHandler(PostNotAllowed e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(DetailNotFound.class)
    public ResponseEntity<ExceptionDto> defaultHandler(DetailNotFound e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(PostNotFound.class)
    public ResponseEntity<ExceptionDto> defaultHandler(PostNotFound e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDto>> defaultHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ExceptionDto> processFieldErrors = processFieldErrors(fieldErrors);
        return ResponseEntity.badRequest().body(processFieldErrors);
    }

    private List<ExceptionDto> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDto> listaDtos = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            listaDtos.add(new ExceptionDto(fieldError.getField(), fieldError.getDefaultMessage()));

        }
        return listaDtos;
    }

}
