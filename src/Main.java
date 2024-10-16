public class Main {
    public static void main(String[] args) {
        String testPassword = "123_fref";
        String testLogin = "_fwfref123_";
        boolean result = Lesson2Class.setPasswordAndLogin(testLogin, testPassword, testPassword);
        System.out.println(result);
    }
}
