/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generala;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Copy&&Paste
 */
public class Generala {
    
    public static void main(String[] args) {
         
        String dados;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese los 5 dados: ");
        dados = entrada.nextLine();
        
        int[] n = Stream.of(dados.split(" ")).mapToInt(Integer::parseInt).toArray(); // Convertir array String a Int
        int resu[] = generala(n[0],n[1],n[2],n[3],n[4]);
        
        String puntos = "|";
        
        for(int i=0; i<resu.length; i++){ 
            puntos += resu[i]+"|"; // Convertir array a String
        }
        
        System.out.println("PUNTOS:\n");
        System.out.println(puntos);
        
    }
     
    public static int[] generala(int a,int b,int c,int d,int e){
         
        int n[] = {a,b,c,d,e};
        Arrays.sort(n); // Funcion para ordenar de menor a mayor los dados en el array
        
        int puntos[] = {0,0,0,0,0,0,0,0,0,0}; // Array para los puntos
        int ide[] = {0,0,0,0,0,0};  // Array contador de dados iguales
        
        // 3 arrays posibles de escaleras
        int esc[] = {1, 2, 3, 4, 5}; 
        int esc2[] = {2, 3, 4, 5, 6}; 
        int esc3[] = {1, 3, 4, 5 ,6}; 
        
        for (int i=0; i<5; i++){
            
            switch(n[i]){
                case 1: puntos[0]+= 1; ide[0]++; break;
                case 2: puntos[1]+= 2; ide[1]++; break;
                case 3: puntos[2]+= 3; ide[2]++; break; 
                case 4: puntos[3]+= 4; ide[3]++; break;
                case 5: puntos[4]+= 5; ide[4]++; break;
                case 6: puntos[5]+= 6; ide[5]++; break;
            } 
        }
        
        if (Arrays.equals(n, esc) || Arrays.equals(n, esc2) || Arrays.equals(n, esc3)){ // Si el array dados coincide con alguno de los 3 arrays de escalera
            puntos[6] = 20;
        }
       
        for(int i = 0;i <ide.length; i++){
            
            if (ide[i] == 2){
                
                for(int j = 0; j <ide.length; j++){
                    
                    if (ide[j] == 3){
                        puntos[7] = 30;
                        break;
                    }
                    
                }
                break;
            }
            else
            if (ide[i] >= 4){
                
                puntos[8] = 40;
                
                if (ide[i] == 5){
                    puntos[9] = 50;
                }
                
                break;
            }
            
        }
        
        return puntos;
    }
}
