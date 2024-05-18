package edu.ejercicios;

import java.text.Normalizer;
import java.util.Stack;

public class Palindromo{

    public static void main(String[] args) {
        String palabra = "A man, a plan, a canal, Panama!";

        if (esPalindromo(palabra)) {
            System.out.println("La palabra es un palíndromo.");
        } else {
            System.out.println("La palabra no es un palíndromo.");
        }
    }

    public static boolean esPalindromo(String palabra) {
        // Limpieza de la cadena
        String limpia = limpiarCadena(palabra);

        // Uso de pila para verificar si es un palíndromo
        Stack<Character> pila = new Stack<>();

        // Agregar cada caracter a la pila
        for (char c : limpia.toCharArray()) {
            pila.push(c);
        }

        // Reconstruir la cadena desde la pila (invertida)
        StringBuilder invertida = new StringBuilder();
        while (!pila.isEmpty()) {
            invertida.append(pila.pop());
        }

        // Comparar la cadena limpia con su versión invertida
        return limpia.equals(invertida.toString());
    }

    public static String limpiarCadena(String cadena) {
        // Convertir a minúsculas
        cadena = cadena.toLowerCase();

        // Eliminar espacios en blanco y caracteres no deseados
        cadena = cadena.replaceAll("[^a-z]", "");

        // Eliminar tildes
        cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        cadena = cadena.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        return cadena;
    }
}
