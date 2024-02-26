package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetails {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String zipcode;
}
