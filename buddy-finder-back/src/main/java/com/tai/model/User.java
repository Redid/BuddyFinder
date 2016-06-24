package com.tai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tai.service.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by izabella on 23.04.16.
 */
@Document(collection = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"password", "email"})
public class User extends AbstractModel {
    private String password;
    private String login;
    private String lastName;
    private String firstName;
    private String email;
    private String sex;
    private Integer age;
}
