import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Lesson2Class {
    public static boolean setPasswordAndLogin(String login, String password, String confirmPassword) {
        try {
            if (login.length()>=20 || isContainingWrongSymbols(login)) {
                throw new WrongLoginException("Login is wrong");
            }
            if (password.length()>=20 ||
                    isContainingWrongSymbols(password) ||
                    !Objects.equals(password, confirmPassword)) {
                throw new WrongPasswordException("Password is wrong");
            }
            return true;
        }
        catch (WrongLoginException | WrongPasswordException ex){
            ex.printStackTrace();
            return false;
        }
    }

    private static boolean isContainingWrongSymbols(String str) {
        String regex = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(regex);
        return !pattern.matcher(str).matches();
    }
}
