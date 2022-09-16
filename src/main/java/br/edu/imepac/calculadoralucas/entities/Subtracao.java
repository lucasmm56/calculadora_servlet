/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.calculadoralucas.entities;

import br.edu.imepac.calculadoralucas.interfaces.Calculadora;

/**
 *
 * @author lucas
 */
public class Subtracao implements Calculadora {
 
        @Override
    public double CalculaOperacao(double num1, double num2) {
       double resultado = num1-num2;
       return resultado;
    }
}
