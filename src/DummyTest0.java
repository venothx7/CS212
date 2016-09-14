/**
 * Created by Venoth on 9/9/2016.
 */
import javax.swing.*;
public class DummyTest0 {

    public static void main(String[] args) {
        int result= JOptionPane.showConfirmDialog(null, "Would you like to add a Student","Students", JOptionPane.YES_NO_OPTION);
        System.out.println(result);
        if(result == JOptionPane.YES_OPTION){
            System.out.println("yes");
        }
        else{
            System.out.println("No");
        }
    }



}
