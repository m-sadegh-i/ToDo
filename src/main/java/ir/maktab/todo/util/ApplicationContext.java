package ir.maktab.todo.util;

import ir.maktab.todo.repository.impl.ActivityRepositoryImpl;
import ir.maktab.todo.repository.impl.UserRepositoryImpl;
import ir.maktab.todo.service.CaseOperations;
import ir.maktab.todo.service.impl.ActivityServiceImpl;
import ir.maktab.todo.service.impl.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationContext {

    private static final Menu menu = new Menu();

    private static final Scanner numericScanner = new Scanner(System.in);

    private static final Scanner textScanner = new Scanner(System.in);

    private static final UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

    private static final CaseOperations caseOperation = new CaseOperations();

    private static final UserServiceImpl userServiceImpl = new UserServiceImpl(userRepositoryImpl);

    private static final ActivityRepositoryImpl activityRepositoryImpl = new ActivityRepositoryImpl();

    private static final ActivityServiceImpl activityServiceImpl = new ActivityServiceImpl(activityRepositoryImpl);

    public static ActivityServiceImpl getActivityServiceImpl() {
        return activityServiceImpl;
    }

    public static ActivityRepositoryImpl getActivityRepositoryImpl() {
        return activityRepositoryImpl;
    }

    public static UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }

    public static CaseOperations getCaseOperation() {
        return caseOperation;
    }

    public static UserRepositoryImpl getUserRepositoryImpl() {
        return userRepositoryImpl;
    }

    public static int intFromScannerReturn(int number) {
        do {
            try {
                number = ApplicationContext.getNumericScanner().nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter an Integer Number !");
                ApplicationContext.getNumericScanner().next();
            }
        } while (number < 1);
        return number;
    }

    public static Scanner getNumericScanner() {
        return numericScanner;
    }

    public static Scanner getTextScanner() {
        return textScanner;
    }

    public static Menu getMenu() {
        return menu;
    }
}
