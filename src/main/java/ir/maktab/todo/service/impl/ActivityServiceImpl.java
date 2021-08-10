package ir.maktab.todo.service.impl;

import ir.maktab.todo.base.service.impl.BaseServiceImpl;
import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.repository.impl.ActivityRepositoryImpl;
import ir.maktab.todo.service.ActivityService;

import java.util.Comparator;
import java.util.List;

public class ActivityServiceImpl extends BaseServiceImpl<Activity, Long, ActivityRepositoryImpl> implements ActivityService {
    public ActivityServiceImpl(ActivityRepositoryImpl repository) {
        super(repository);
    }

    public boolean isEnteredIdMatch(User activeUser, int activityId) {

        for (Activity activities : activeUser.getActivities()) {
            if (activities.getId() == (long) activityId) {
                return true;
            }
        }
        return false;
    }

    public static class SubjectComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity activity1, Activity activity2) {
            return activity1.getStatus().compareTo(activity2.getSubject());
        }
    }

    public static class CreateDateComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity activity1, Activity activity2) {
            return activity1.getCreatedDate().compareTo(activity2.getCreatedDate());
        }
    }

    public static class StatusComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity activity1, Activity activity2) {
            return activity1.getStatus().compareTo(activity2.getStatus());
        }
    }

    public static class UpdateDateComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity activity1, Activity activity2) {
            return activity1.getUpdateDate().compareTo(activity2.getUpdateDate());
        }
    }

    public void printUserActivities(List<Activity> activities) {
        for (Activity userActivity : activities) {
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><>");
            System.out.println("*** Activity ID : " + userActivity.getId());
            System.out.println("*** Activity Subject : " + userActivity.getSubject());
            System.out.println("*** Activity Status : " + userActivity.getStatus());
            System.out.println("*** Activity Create Date : " + userActivity.getCreatedDate());
            System.out.println("*** Activity Update Date : " + userActivity.getUpdateDate());
            System.out.println("==================================================");
        }
    }

}
