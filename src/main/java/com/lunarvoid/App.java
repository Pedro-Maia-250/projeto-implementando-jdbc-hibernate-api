package com.lunarvoid;

import java.util.Scanner;
import com.lunarvoid.entities.Quadrado;

public class App {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("digite o nome da forma: ");
            String nome = sc.next();

            System.out.print("Digite a medida do lado da forma: ");
            Double lado = sc.nextDouble();

            Quadrado quad = new Quadrado(nome, lado);

            System.out.println(quad);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
