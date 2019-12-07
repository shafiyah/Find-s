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
public class Hipertensi {

    public String[] attribut = {"Umur","Kegemukan"};
    public String[][] data ={{"Paruh Baya","Terlalu Gemuk"},
                             {"Tua","Terlalu Gemuk"}};
    public String[] dataTest = new String[2];
    public String[] hipotesa = new String[2];
    
    public void input(){
        Scanner input = new Scanner(System.in);
        for(int i=0;i<dataTest.length;i++){
          System.out.print("masukan nilai attribut "+attribut[i]+" = ");
          dataTest[i]=input.nextLine();
        }
    }
    
    public void learningProses(){
        for(int i = 0; i < data.length; i++){
            for(int j=0; j< hipotesa.length; j++){
                if(i==0){
                    hipotesa[j]=data[i][j];
                }
                else{
                    if(data[i][j].equalsIgnoreCase(hipotesa[j])){
                       hipotesa[j] = data[i][j];
                    }
                    else{
                         hipotesa[j] = "?";
                    }
                }
            }
        }
    }
    
    public void generaceOutput(){
        for(int i=0;i<dataTest.length;i++){
            if(!dataTest[i].equalsIgnoreCase(hipotesa[i])){
                if(!hipotesa[i].equals("?")){
                    System.out.println("Tidak");
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
        System.out.println("TIDAK = [?, ?]\n");
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
        System.out.println("aplikasi Consep Learning Facts (Hipertensi)\n");
        Hipertensi finds = new Hipertensi();
        finds.runProgram();
    } 
}


