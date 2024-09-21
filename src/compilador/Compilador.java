/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compilador;

import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.List;
import auxiliares.Error;
import auxiliares.Archivo;

/**
 *
 * @author abmon
 */
public class Compilador {

    public static final Error listaDeErrores = new Error();
    public static String archivoAdjunto;

    public static void main(String[] args) {

        if (validarArchivoParaAnalizar(args)) {
            archivoAdjunto = args[0]; //Solo hay un archivo para analizar
            if (validarExtensionArchivoParaAnalizar(archivoAdjunto)) {
                System.out.println("""
                                        28 BORRAR: ESTAMOS ANALIZANDO LA EXTENSION DEL ARCHIVO PARA ANALZAR
                                       """);

                try {
                    Archivo archivo = new Archivo();
                    
                    //Lee el archivo para analizar y crea una lista de array con cada linea del archivo para analizar
                    List<String> contenidoArchivo = archivo.leerArchivo(archivoAdjunto);
                    System.out.println("""
                                       
                                       35 BORRAR: ESTE ES EL CONTENIDO DEL ARCHIVO GATO.PY
                                       
                                       """);
                    imprimirListas(contenidoArchivo); //BORRAR
                    String nombreArchivo = "salida.txt";
                    archivo.escribirArchivo(contenidoArchivo, nombreArchivo);
                    System.out.println("""
                                        
                                       41 BORRAR: ESTE ES EL CONTENIDO DEL ARCHIVO SALIDA.TXT
                                       
                                       """);
                    archivo.imprimirArchivo(nombreArchivo);

                    /*
                    String content = new String(Files.readAllBytes(Paths.get(filePath)));
                    List contenidoArchivoParaAnalizar
                            = Lexer lexer = new Lexer(content);
                    lexer.tokenize();
                    Parser parser = new Parser(lexer.getTokens());
                    parser.parse();
                    ErrorChecker errorChecker = new ErrorChecker(parser.getASTNodes(), parser.getSymbolTable());
                    errorChecker.checkErrors();
                     */
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }

        } else {
            System.exit(0);
        }

    } // fin metodo main

    //Verifica que exista un solo archivo a analizar 
    public static boolean validarArchivoParaAnalizar(String[] args) {

        if (args.length == 0) {
            JOptionPane.showMessageDialog(null, listaDeErrores.obtenerDescripcionDeError(100), "Error en archivo", JOptionPane.WARNING_MESSAGE);
            System.out.println(" 73 BORRAR " + listaDeErrores.obtenerDescripcionDeError(100));
            return false;
        } else if (args.length > 1) {
            JOptionPane.showMessageDialog(null, listaDeErrores.obtenerDescripcionDeError(101), "Error en archivo", JOptionPane.WARNING_MESSAGE);
            System.out.println("77 Borrar " + listaDeErrores.obtenerDescripcionDeError(101));
            return false;
        } else {
            System.out.println("81 BORRAR: Este es el archivo para analizar: " + args[0]);
            return true;

        }

    }

    //Verifica que la extension del archivo a analizar tenga extension .py
    public static boolean validarExtensionArchivoParaAnalizar(String archivo) {
        System.out.println("89 BORRAR: Archivo con extension correcta: " + archivo.toLowerCase().endsWith(".py"));
        if(archivo.toLowerCase().endsWith(".py")){
            return true;
        } else {
           JOptionPane.showMessageDialog(null, listaDeErrores.obtenerDescripcionDeError(102), "Código Fuente", JOptionPane.WARNING_MESSAGE); 
           System.out.println(" 94 BORRAR " + listaDeErrores.obtenerDescripcionDeError(102));
           return false;
        }
    }

    //Recorre una lista de string y la imprime BORRAR
    public static void imprimirListas(List<String> contenidoArchivo) {
        for (String linea : contenidoArchivo) {
            System.out.println(linea);
        }
    }

}
