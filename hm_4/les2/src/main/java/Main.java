
import models.User;

import java.util.Scanner;

public class Main {

    //main + enter
    public static void main(String[] args) {

        //create manager for work with users
        UserManager manager = new UserManager();

        //create scanner for work with customer
        Scanner in = new Scanner(System.in);

        //if we want stop
        boolean stop = true;

        do{
            //show menu
            System.out.println("Menu CRUD");
            System.out.println("1.Create user");
            System.out.println("2.Read all users");
            System.out.println("3.Update user");
            System.out.println("4.Delete user");
            System.out.println("5.Stop");
            System.out.println("choose: ");
            int choose = in.nextInt();

            switch (choose){
                case 1: //create user
                    //if we want enter name
                    //System.out.println("Enter name: ");
                    // String name;
                    // name = in.nextLine();

                    //random name
                    manager.AddUser(manager.FillRandomAndReturnUser());

                    break;
                case 2: //Read and show users
                    manager.ShowUsers();
                    System.out.println();
                    in.nextLine();
                    break;
                case 3: //update some user name by id
                    System.out.println("Enter id: ");
                    int us_id = in.nextInt();

                    System.out.println("Enter name: ");
                    String us_name = in.nextLine();
                    us_name = in.nextLine();

                    manager.UpdateUser(new User(us_id, us_name));
                    break;
                case 4: // delete some user by id
                    System.out.println("Enter id: ");
                    int us_id_del = in.nextInt();

                    manager.DeleteUser(us_id_del);
                    break;
                case 5: //stop program working
                    stop=false;
                    break;
                default:
                    System.out.println("Incorrect input!");
                    break;
            }

        }while (stop);
    }
}
