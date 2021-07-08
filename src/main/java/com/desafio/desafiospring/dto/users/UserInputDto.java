package com.desafio.desafiospring.dto.users;

import com.desafio.desafiospring.enums.UserType;
import com.desafio.desafiospring.exceptions.UserTypeNotDefined;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserInputDto {

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    private UserType type;

    public UserInputDto() {

    }

    public UserInputDto(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getType() {
        return type;
    }

    public void setType(String type) {

        switch (type.toLowerCase()){
            case "seller":
               this.type = UserType.SELLER;
               break;
            case "buyer":
                this.type = UserType.BUYER;
                break;
            default:
                throw new UserTypeNotDefined("Tipo de usuário não suportado pelo sistema (são suportados apenas seller ou buyer)");

        }

    }
}
