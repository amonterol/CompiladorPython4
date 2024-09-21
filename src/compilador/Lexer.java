/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abmon
 */
public class Lexer {

    private List<String> contenidoDelArchivo; //Código que se analiza en forma de lista
    private List<String> listaDeTokens; //Almacena los tokens que se identifican
    private int cantidadComentarios; // almacena la cantidad de comentarios en el código
    private int numeroLineaActual;

    public Lexer(List<String> content) {
        this.contenidoDelArchivo = content;
        this.listaDeTokens = new ArrayList<>();
        this.cantidadComentarios = 0;
        this.numeroLineaActual = 1;
    }

    public void analizadorLexico(List<String> contenido) throws IOException {

        listaDeTokens = new ArrayList<>();
        for (String lineaDeCodigo : contenidoDelArchivo) {

            
            
            //Verifica si la linea esta en blanco
            if (lineaDeCodigo.isBlank() || lineaDeCodigo.isEmpty()) {
                System.out.println("\n 1 LEXER BORRAR ES UN NUEVA LINEA DE CODIGO ESTA EN BLANCO " + lineaDeCodigo);
                System.out.println("\n 2 LEXER BORRAR ES UN NUEVA LINEA DE CODIGO ESTA EN BLANCO " + numeroLineaActual);
                continue;

            }
            
            //Verifica si la linea es un comentario o si hay comentarios al final de una linea de código
            if (existeComentario(lineaDeCodigo)) {
                cantidadComentarios++;
                lineaDeCodigo = lineaDeCodigo.split("#")[0].trim(); // Elimina la parte del comentario en la línea
            }

       
            
            //Convierte cada línea de código en un arreglo de caracteres para recorrer caracter por caracter e identificar su tipo
            char[] arregloCaracteres = lineaDeCodigo.toCharArray();
            
            
        }

        

    }

    //Verifica si la linea de codigo que se esta leyendo contiene un comentario
    public boolean existeComentario(String lineaActual) {
        Character caracterDeComentario = '#';

        System.out.println(" Existe el caracter de comentarios " + lineaActual.contains(String.valueOf(caracterDeComentario)));
        return lineaActual.contains(String.valueOf(caracterDeComentario));

    }

}
