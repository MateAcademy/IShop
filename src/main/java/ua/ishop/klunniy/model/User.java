package ua.ishop.klunniy.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Serhii Klunniy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long userId;
    String email;
    String password;
    String passwordNotEncoded;
    LocalDateTime createDate;
    LocalDateTime updateDate;
    List<Role> roleList;

    public User(String email, String passwordNotEncoded) {
        this.email = email;
        this.passwordNotEncoded = passwordNotEncoded;
    }

    public User(Long userId, String email, String passwordNotEncoded) {
        this.userId = userId;
        this.email = email;
        this.passwordNotEncoded = passwordNotEncoded;
    }

    public User(Long userId, String email, String password, String passwordNotEncoded, LocalDateTime createDate, LocalDateTime updateDate) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.passwordNotEncoded = passwordNotEncoded;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
