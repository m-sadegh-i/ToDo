package ir.maktab.todo;

import ir.maktab.todo.domain.User;
import ir.maktab.todo.util.ApplicationContext;

public class ToDoApp {

    public static void main(String[] args) {

        boolean mainMenuRepeat = true;
        while (mainMenuRepeat) {
            ApplicationContext.getMenu().showMainMenu();
            int mainMenuSwitch = 0;
            mainMenuSwitch = ApplicationContext.intFromScannerReturn(mainMenuSwitch);

            switch (mainMenuSwitch) {
                case 1:
                    System.out.println("Signing Up :");
                    System.out.println("===============");
                    ApplicationContext.getCaseOperation().signUp();
                    break;

                case 2:
                    System.out.println("Signing in:");
                    System.out.println("===============");
                    User activeUser = ApplicationContext.getCaseOperation().signIn();

                    boolean signedInMenuRepeat = true;
                    while (signedInMenuRepeat) {
                        ApplicationContext.getMenu().showSignedInMenu();
                        int signInMenuSwitch = 0;
                        signInMenuSwitch = ApplicationContext.intFromScannerReturn(signInMenuSwitch);

                        switch (signInMenuSwitch) {
                            case 1:
                                activeUser = ApplicationContext.getUserServiceImpl().changePassword(activeUser);
                                break;

                            case 2:
                                ApplicationContext.getCaseOperation().addNewActivity(activeUser);
                                break;

                            case 3:
                                ApplicationContext.getCaseOperation().updateActivityStatus(activeUser);
                                break;

                            case 4:
                                ApplicationContext.getCaseOperation().showActivities(activeUser);
                                break;

                            default:
                                signedInMenuRepeat = false;
                        }
                    }
                    break;

                default:
                    mainMenuRepeat = false;
            }
        }
    }
}
