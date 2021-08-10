package ir.maktab.todo.util;

public class Menu {

    public void showMainMenu() {
        System.out.println("*** Activity Manager ***");
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");
        System.out.println("3. Exit");
    }

    public void showSignedInMenu() {
        System.out.println();
        System.out.println("1. Change Your Password");
        System.out.println("2. Add A New Activity");
        System.out.println("3. Edit An Activity Status");
        System.out.println("4. Show Your Activities");
        System.out.println("5. Sign Out");
    }

    public void showActivityStatusMenu() {
        System.out.println("1. Open");
        System.out.println("2. In Progress");
        System.out.println("3. Completed");
    }

    public void showSortMenu() {
        System.out.println("1. Sort By Subject");
        System.out.println("2. Sort By CreateDate");
        System.out.println("3. Sort By Status");
        System.out.println("4. Sort By Update Date");
    }

    public void showAscDescInSortMenu() {
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
    }

}
