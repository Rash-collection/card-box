/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cardbox;

/**
 * <p>Main class >> main method</p>
 * @author rash4
 */
public class Launch {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        if(new testy.DragDrop().readFile(args)){
            System.out.println("======END=======");
        }
        new gui.WinAdapter("Maan!").thisGAGA();
    }
}