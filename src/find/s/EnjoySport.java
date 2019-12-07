/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.s;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Shaf
 */
public class EnjoySport {

    public String attribut[] = {"Sky","AirTemp","Humidity","Wind","Water","Forecast"};
    public String data[][]={
                            {"Sunny","Warm","Normal","Strong","Warm","Same"},
                            {"Sunny","Warm","High","Strong","Warm","Same"},
                            {"Sunny","Warm","High","Strong","Cool","Change"},
                           };
    public String[] dataTest = new String [6];
    public String[] hipotesa  = new String[6];
    
    public  void input(){
       Scanner input = new Scanner(System.in);
       for(int i=0;i<dataTest.length;i++){
             System.out.print("masukan atribut " +attribut[i]+" = ");
             dataTest[i] = input.nextLine();     
       }
    } 
    
    public void learningProses(){
        for(int i=0;i<data.length;i++){
            for(int j=0;j<hipotesa.length;j++){
                if(i==0){
                    hipotesa[j]=data[i][j];
                }
                else{
                    if(data[i][j].equalsIgnoreCase(hipotesa[j])){
                      hipotesa[j]=data[i][j];
                    }
                    else{
                    hipotesa[j]="?";  
                    }
                }
            }
        }     
    }
    
    public void generaceOutput(){
      for(int i=0;i<dataTest.length;i++){
        if(!dataTest[i].equalsIgnoreCase(hipotesa[i])){
            if(!hipotesa[i].equals("?")){
                System.out.println("TIDAK");
                break;
             }
        }
        if(i==dataTest.length-1){
            System.out.println("IYA");
        } 
      }
    }
    
    public void printHipotesa(){
        System.out.println("HIPOTESA");
        System.out.print("IYA = ");
        System.out.println(Arrays.deepToString(hipotesa));
        System.out.println("TIDAK =[?, Cold, High, ?, ?, ?] \n");
    }
    
    public void runProgram(){
        String again;
        Scanner in = new Scanner(System.in);
        learningProses();
        printHipotesa();
        do{
            input();
            generaceOutput();
            System.out.print("\ntry again (y/n) ? ");
            again = in.nextLine();
        }while(again.equals("y"));
    }
    
    public static void main(String[] args) {
        System.out.println("Aplikasi Consep Learning Facts \n");
        EnjoySport finds = new EnjoySport();
        finds.runProgram();
    }
}
