package ua.ishop.klunniy.dao;

import ua.ishop.klunniy.model.Code;
import ua.ishop.klunniy.model.User;

/**
 * @author Serhii Klunniy
 */
public interface CodeDao {
    void add(Code code);

    Code getCode(User user);
}
