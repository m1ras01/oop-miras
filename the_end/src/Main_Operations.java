import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;

public class Main_Operations{
    public boolean isTrue;
    public int count;
    RunTimer time = new RunTimer(isTrue, count);

    public Main_Operations(boolean isTrue, int count) throws SQLException {
        this.isTrue = isTrue;
        this.count = count;
    }
    public void call_op(boolean isTrue, int count) throws SQLException, NoSuchAlgorithmException {
        while (!isTrue){

            System.out.print("Username or IIN: ");
            Scanner log = new Scanner(System.in);
            String login = log.nextLine();
            System.out.print("Password: ");
            Scanner pas = new Scanner(System.in);
            String pass = pas.nextLine();
            CheckInfo CheckInfo = new CheckInfo(login, pass);
            CheckFunct CheckFunctionality = new CheckFunct(login, pass);
            if(!CheckFunctionality.checklogin(login)){
                isTrue = false;
            }
            else{
                if(CheckFunctionality.checklength(pass)){
                }
                else {
                    if (CheckInfo.checkinf()) {

                        isTrue = true;
                    } else {
                        count++;
                        time.timeRun(count);
                    }
                }
            }
        }
    }
}
