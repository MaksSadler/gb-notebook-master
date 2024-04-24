package notebook.util;

import notebook.model.User;

public class UserValidator {
   public User validate(User user) {
        // A N n A учимся удалять пробелы.
        //метод trim() чистит пробелы в начале и в конце строки.
        String name = user.getFirstName().replaceAll(" ","").trim();
        String lastName = user.getLastName().replaceAll(" ","").trim();
        user.setFirstName(name);
        user.setLastName(lastName);
        return user;
    }
}
