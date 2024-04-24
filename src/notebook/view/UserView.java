package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = userController.prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase().trim());
            if (com == Commands.EXIT) return;
            switch (com) {
                case DELETE:
                    String usersId = userController.prompt("Enter user id: ");
                    userController.deleteUser(usersId);
                case LIST:
                    System.out.println(userController.readAll());
                    break;
                case CREATE:
                    User u = userController.createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = userController.prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case UPDATE:
                    String userId = userController.prompt("Enter user id: ");
                    userController.updateUser(userId, userController.createUser());
            }
        }
    }

//    private String prompt(String message) {
//        Scanner in = new Scanner(System.in);
//        System.out.print(message);
//        return in.nextLine();
//    }

//    private User createUser() {
//        String firstName = prompt("Имя: ");
//        String lastName = prompt("Фамилия: ");
//        String phone = prompt("Номер телефона: ");
//        return new User(firstName, lastName, phone);
//    }
}
