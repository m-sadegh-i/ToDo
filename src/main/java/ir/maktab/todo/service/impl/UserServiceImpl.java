package ir.maktab.todo.service.impl;

import ir.maktab.todo.base.service.impl.BaseServiceImpl;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.repository.impl.UserRepositoryImpl;
import ir.maktab.todo.util.ApplicationContext;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepositoryImpl> {

    public UserServiceImpl(UserRepositoryImpl repository) {
        super(repository);
    }

    public boolean isValidUsername(String username) {

        if (username.isEmpty()) {
            System.out.println("You Entered Nothing");
            return false;
        }

        for (User users : ApplicationContext.getUserRepositoryImpl().findAll()) {
            if (users.getUserName().equals(username)) {
                System.out.println("This Username Already Exists, Please Try Another One");
                return false;
            }
        }

        return true;
    }

    public boolean isValidNationalCode(String nationalCode) {

        if (nationalCode.length() != 10) {
            System.out.println("National Code has 10 Digits !");
            return false;
        }

        if (nationalCode.isEmpty()) {
            System.out.println("You Entered Nothing !");
            return false;
        }

        for (int i = 0; i < nationalCode.length(); i++) {
            if (!((int) nationalCode.charAt(i) >= 48 && (int) nationalCode.charAt(i) <= 57)) {
                System.out.println("Enter Only Numbers !");
                return false;
            }
        }

        for (User users : ApplicationContext.getUserRepositoryImpl().findAll()) {
            if (users.getNationalCode().equals(nationalCode)) {
                System.out.println("This National Already Exists !");
                return false;
            }
        }

        return true;
    }

    public boolean checkUsernamePassword(String username, String password) {

        for (User users : ApplicationContext.getUserRepositoryImpl().findAll()) {
            if (users.getUserName().equals(username) && users.getPassWord().equals(password)) return true;
        }

        return false;
    }

    public User changePassword(User activeUser) {
        String password;
        System.out.println("Enter Your Present Password : ");
        password = ApplicationContext.getTextScanner().next();
        if (activeUser.getPassWord().equals(password)) {
            System.out.println("Please Enter Your New Password: ");
            password = ApplicationContext.getTextScanner().next();
            activeUser.setPassWord(password);
            transaction.begin();
            entityManager.merge(activeUser);
            transaction.commit();
            System.out.println("Your Password Changed Successfully !");
        } else {
            System.out.println("Password doesn't Match !");
        }
        return activeUser;
    }

}
