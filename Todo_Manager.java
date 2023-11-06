import java.util.Scanner;
import java.util.ArrayList;
public class Todo_Manager {
    // Using ArrayList for storing a tasks
    static ArrayList<String> tasks = new ArrayList<> ();
    static void display_Menu(){
        System.out.println ( "----------------------------Welcome To-Do List Application-----------------------------" );
        System.out.println ( "1. Mark Task as Complete" );
        System.out.println ( "2. View Tasks" );
        System.out.println ( "3. Remove Task" );
        System.out.println ( "4. Add more Tasks" );
        System.out.println ( "---------------------------------------------------------------------------------------" );
    }
    static void add_tasks() {
        Scanner sc = new Scanner ( System.in );
        System.out.println ( "Enter the Task Description : " );
        String task = sc.nextLine ();
        tasks.add ( task );
        System.out.println ( "Task added : " + task );
    }
    static void view_tasks() {
        if ( tasks.isEmpty () ) {
            System.out.println ( "Task Completed" );
        } else {
            System.out.print ( "To-DO Tasks : " );
            for (int i = 0; i < tasks.size (); i++) {
                System.out.println ( "Tasks >>> " + (i + 1) + " : " + tasks.get ( i ) );
            }
        }
    }
    static void remove_tasks() {
        System.out.print ( "Enter the task number to remove: " );
        Scanner sc = new Scanner ( System.in );
        int taskNumber = sc.nextInt ();
        if ( taskNumber >= 1 && taskNumber <= tasks.size () ) {
            String removed_Task = tasks.remove ( taskNumber - 1 );
            System.out.println ( "Task removed: " + removed_Task );
        } else {
            System.out.println ( "Invalid task number." );
        }
    }
    static void Complete_tasks() {
        System.out.print ( "Enter the task number to mark as complete: " );
        Scanner sc = new Scanner ( System.in );
        int taskNumber = sc.nextInt ();
        if ( taskNumber >= 1 && taskNumber <= tasks.size () ) {
            String complete_task = tasks.get ( taskNumber - 1 );
            tasks.set ( taskNumber - 1, "[Completed] " + complete_task );
            System.out.println ( "Task marked as complete: " + complete_task );
        } else {
            System.out.println ( "Invalid task number." );
        }
    }
    public static void main(String[] args) {
        display_Menu ();
        add_tasks ();
            int choice;
            Scanner scanner = new Scanner ( System.in );
            System.out.print ( "Enter your choice :" );
            choice = scanner.nextInt ();
        switch (choice) {
            case 1 -> Complete_tasks ();
            case 2 -> view_tasks ();
            case 3 -> remove_tasks ();
            case 4 -> add_tasks ();
        }
        // While loop helps to run the app for multiple times
        while (true) {
            System.out.println ( "Do you want to continue : ? yes/no" );
            Scanner sc=new Scanner ( System.in );
              String ans = sc.nextLine ().toLowerCase ();
                    if ( ans.equals ( "yes" ) ) {
                        System.out.print ( "Enter your choice :" );
                        choice = sc.nextInt ();
                        switch (choice) {
                            case 1:
                                Complete_tasks ();
                            case 2:
                                view_tasks ();
                                break;
                            case 3:
                                remove_tasks ();
                            case 4:
                                add_tasks ();
                        }
                    } else if ( ans.equals ( "no" ) )
                    {
                        System.out.println ( "Exit" );
                        break;
                    }
        }
    }
}