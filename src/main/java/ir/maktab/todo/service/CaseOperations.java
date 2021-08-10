package ir.maktab.todo.service;

import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.domain.ActivityStatus;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.service.impl.ActivityServiceImpl;
import ir.maktab.todo.util.ApplicationContext;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CaseOperations {

    public void signUp() {

// ............ Get Username and Validation ............ //
        String username;
        do {
            System.out.println("Username:");
            username = ApplicationContext.getTextScanner().next();
        } while (!ApplicationContext.getUserServiceImpl().isValidUsername(username));

        // ............ Get National Code and Validation ............ //
        String nationalCode;
        do {
            System.out.println("National Code:");
            nationalCode = ApplicationContext.getTextScanner().next();
        } while (!ApplicationContext.getUserServiceImpl().isValidNationalCode(nationalCode));

        // ............ Set National Code as Default Password ............ //
        String password = nationalCode;

        // ............ Insert Person into Database ............ //

        ApplicationContext.getUserRepositoryImpl().save(new User(username, password, nationalCode));

        System.out.println("NOTICE: Your Password is Your National Code.");
        System.out.println("You Can Change It Later.");
    }

    public User signIn() {

        String username;
        String password;

        while (true) {
            System.out.println("Username: ");
            username = ApplicationContext.getTextScanner().next();
            System.out.println("Password:");
            password = ApplicationContext.getTextScanner().next();
            if (ApplicationContext.getUserServiceImpl().checkUsernamePassword(username, password)) {
                break;
            } else {
                System.out.println("Wrong Username or Password !");
            }
        }

        // ............ Welcome Message ............ //
        System.out.println("Welcome " + "\uD83C\uDF3A " + username + " \uD83C\uDF3A");

        return ApplicationContext.getUserRepositoryImpl().findByUsername(username);
    }

    public void addNewActivity(User activeUser) {

        String subject;
        String status = String.valueOf(ActivityStatus.OPEN);

        ApplicationContext.getTextScanner().nextLine();
        System.out.println("Please Enter The Subject of Your Activity :");
        subject = ApplicationContext.getTextScanner().nextLine();

        ApplicationContext.getMenu().showActivityStatusMenu();
        System.out.println("Please Choose Your Activity Status :");

        int statusCase = 0;
        statusCase = ApplicationContext.intFromScannerReturn(statusCase);
        switch (statusCase) {
            case 1:
                status = String.valueOf(ActivityStatus.OPEN);
                break;
            case 2:
                status = String.valueOf(ActivityStatus.IN_PROGRESS);
                break;
            case 3:
                status = String.valueOf(ActivityStatus.COMPLETED);
                break;
            default:
                break;
        }
        Activity activeUserActivity = new Activity(subject, status,
                Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
        try {
            activeUser.getActivities().add(activeUserActivity);
        } catch (NullPointerException e) {
            ArrayList<Activity> userActivities = new ArrayList<>();
            userActivities.add(activeUserActivity);
            activeUser.setActivities(userActivities);
        }

        ApplicationContext.getActivityRepositoryImpl().save(activeUserActivity);
    }

    public void updateActivityStatus(User activeUser) {

        String status = String.valueOf(ActivityStatus.OPEN);

        List<Activity> userActivities = activeUser.getActivities();

        try {
            ApplicationContext.getActivityServiceImpl().printUserActivities(userActivities);
        } catch (NullPointerException e) {
            System.out.println("You Don't Add Any Activities Yet !");
        }


        if (!userActivities.isEmpty()) {
            System.out.println("Please Enter Id Number of Activity :");

            int activityId = 0;
            activityId = ApplicationContext.intFromScannerReturn(activityId);

            if (ApplicationContext.getActivityServiceImpl().isEnteredIdMatch(activeUser, activityId)) {

                System.out.println("Please Choose Your Activity Status Update:");
                ApplicationContext.getMenu().showActivityStatusMenu();
                int updateStatusCase = 0;
                updateStatusCase = ApplicationContext.intFromScannerReturn(updateStatusCase);
                switch (updateStatusCase) {
                    case 1:
                        status = String.valueOf(ActivityStatus.OPEN);
                        break;
                    case 2:
                        status = String.valueOf(ActivityStatus.IN_PROGRESS);
                        break;
                    case 3:
                        status = String.valueOf(ActivityStatus.COMPLETED);
                        break;
                    default:
                        break;
                }

                try {

                    Activity chosenActivity = ApplicationContext.getActivityRepositoryImpl().findById((long) activityId);

                    chosenActivity.setStatus(status);

                    chosenActivity.setUpdateDate(Date.valueOf(LocalDate.now()));

                    ApplicationContext.getActivityRepositoryImpl().update(chosenActivity);

                } catch (IndexOutOfBoundsException e) {

                    System.out.println("Wrong Id !!");

                }
            } else {
                System.out.println("Wrong Id !!");
            }

        } else {
            System.out.println("You Don't Enter any Activities yet !");
        }


    }

    public void showActivities(User activeUser) {
        int ascDesc = 0;
        List<Activity> activeUserActivities = activeUser.getActivities();

        if (!activeUserActivities.isEmpty()) {
            ApplicationContext.getMenu().showSortMenu();
            int sortMenuCase = 0;
            sortMenuCase = ApplicationContext.intFromScannerReturn(sortMenuCase);
            switch (sortMenuCase) {
                case 1:

                    ApplicationContext.getMenu().showAscDescInSortMenu();
                    ascDesc = ApplicationContext.intFromScannerReturn(ascDesc);

                    switch (ascDesc) {

                        case 1:
                            activeUserActivities.sort(new ActivityServiceImpl.SubjectComparator());
                            ApplicationContext.getActivityServiceImpl().printUserActivities(activeUserActivities);
                            break;

                        case 2:
                            activeUserActivities.sort(new ActivityServiceImpl.SubjectComparator().reversed());
                            ApplicationContext.getActivityServiceImpl().printUserActivities(activeUserActivities);
                            break;

                        default:
                            break;
                    }
                    break;

                case 2:
                    ApplicationContext.getMenu().showAscDescInSortMenu();
                    ascDesc = ApplicationContext.intFromScannerReturn(ascDesc);
                    switch (ascDesc) {
                        case 1:
                            activeUserActivities.sort(new ActivityServiceImpl.CreateDateComparator());
                            ApplicationContext.getActivityServiceImpl().printUserActivities(activeUserActivities);
                            break;

                        case 2:
                            activeUserActivities.sort(new ActivityServiceImpl.CreateDateComparator().reversed());
                            ApplicationContext.getActivityServiceImpl().printUserActivities(activeUserActivities);
                            break;

                        default:
                            break;
                    }
                    break;

                case 3:
                    ApplicationContext.getMenu().showAscDescInSortMenu();
                    ascDesc = ApplicationContext.intFromScannerReturn(ascDesc);
                    switch (ascDesc) {
                        case 1:
                            activeUserActivities.sort(new ActivityServiceImpl.StatusComparator());
                            ApplicationContext.getActivityServiceImpl().printUserActivities(activeUserActivities);
                            break;

                        case 2:
                            activeUserActivities.sort(new ActivityServiceImpl.StatusComparator().reversed());
                            ApplicationContext.getActivityServiceImpl().printUserActivities(activeUserActivities);
                            break;

                        default:
                            break;
                    }
                    break;

                case 4:
                    ApplicationContext.getMenu().showAscDescInSortMenu();
                    ascDesc = ApplicationContext.intFromScannerReturn(ascDesc);
                    switch (ascDesc) {
                        case 1:
                            activeUserActivities.sort(new ActivityServiceImpl.UpdateDateComparator());
                            ApplicationContext.getActivityServiceImpl().printUserActivities(activeUserActivities);
                            break;

                        case 2:
                            activeUserActivities.sort(new ActivityServiceImpl.UpdateDateComparator().reversed());
                            ApplicationContext.getActivityServiceImpl().printUserActivities(activeUserActivities);
                            break;
                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
        } else {
            System.out.println("You Don't Add Any Activities Yet !");
        }
    }
}
