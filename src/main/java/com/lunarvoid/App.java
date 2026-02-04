//aqui havera uma implementação de persistencia de dados com uso de uma api em um servidor externo

package com.lunarvoid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lunarvoid.entities.Circulo;
import com.lunarvoid.entities.Forma;
import com.lunarvoid.entities.Quadrado;
import com.lunarvoid.entities.Retangulo;

public class App {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            
            List<Forma> formas = new ArrayList<>();

            formas.add(new Quadrado(2.3));
            formas.add(new Circulo(5.0));
            formas.add(new Retangulo(5.0, 3.6));


            for (Forma forma : formas) {
                System.out.println(forma);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
