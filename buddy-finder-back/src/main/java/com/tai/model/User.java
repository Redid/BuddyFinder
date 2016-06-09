package com.tai.model;

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
public class User extends AbstractModel {
    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private String email;
}
