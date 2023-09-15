package org.unrn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjercicioEntregableBorrador {
    //Realice pruebas sobre el programa, utilizando archivos y los operadores de redirección de la linea de comandos.
    //Para probar en Windows el programa, ejecutar el comando (desde la ruta raiz/src/main/java/org/unrn):
    //Get-Content ..\..\..\resources\comandos-file-windows.txt | java EjercicioEntregable.java -s :
    //Para ejecutar en Linux el programa, ejecuatar el comando (desde la ruta raiz/src/main/java/org/unrn):
    //java EjercicioEntregable.java -s : < comandos-file-windows.txt


    private static volatile boolean terminar = false;
    private static int cantidad = 0;
    private static List<Thread> threads = new ArrayList<>();
    public static int retorno = 0;

    public static void main(String[] args) {


//Además deberá registrar manejadores de señales para INT y TERM.Si se recibe cualquier de las señales,
//deberá dejar de leer la entrada standar y terminar, una vez hayan terminado todos los hilos iniciados.
//El valor de retorno, debe ser cero (0) si termina sin ser detenido o uno(1) si termina a través de una de las señales registradas.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { // Registrar manejadores de señales INT y TERM
            System.err.println("Señal recibida. Terminando...");
            retorno = 1;
            terminar = true;   //terminar hilo actual y todos los otros hilos
//            System.exit(1);//terminar el programa con una señal de 1 por haber detenido el programa
        }));

//El separador, le será indicado por parámetro -s.Si este parámetro no se le indica, el valor por defecto es el caracter tabulador.
        String separador = "\t";
        if (args.length > 0 && args[0].equals("-s"))
            separador = args[1];


//A cada comando a ejecutar, se le deben pasar las mismas variables de entorno que tiene el proceso actual, salvo las variable HOSTNAME.
//La variable HOSTNAME debe ser pasada con el valor “prueba”.
        Map<String, String> entorno = new HashMap<>(System.getenv());
        entorno.put("HOSTNAME", "prueba");
//        System.out.println(entorno);

//Debe leer una lista de comandos por la entrada estandar (Un comando por linea).
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;

            //El programa debe terminar, cuando no queden lineas para leer en la entrada estandar y todos los hilos que inició, hayan terminado.
            System.out.println("Ingrese comandos e ingrese enter.%nPara terminar seleccione enter dos veces o finalice con señales INT o TERM con las teclas Ctrl+C (Windows), Ctrol+Z+Enter (Windows), Ctrol+D (Linux)");
            while (!terminar) {//mientras q no haya terminado lee lineas
                linea = reader.readLine(); //lee la linea

                if (linea == null || linea.isBlank()) { //compara si la linea que leyo no es null o vacio
                    terminar = true; //si es vacio/null entra y termina: deja de leer comandos
                } else {
                    cantidad++;

//Debe ejecutar cada uno de los comandos, en un hilo independiente.
//Cada hilo debe imprimir por la salida standar el comando y el valor de retorno, en formato “comando”separador “retorno”.
                    Thread thread = new Thread(new CommandExecutor(linea, separador, entorno));//creo un hilo
                    threads.add(thread);//agrego el hilo al arreglo de hilos
                    thread.start(); //start al hilo que cree
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer la entrada estándar: " + e.getMessage());
            System.exit(1);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Error al esperar a que termine un hilo: " + e.getMessage());
            }
        }
        //Cuando el programa termine, deberá imprimir por la salida standar la cantidad de lineas leidas o comandos ejecutados.
        System.out.println("Cantidad de Comandos/lineas leidas: " + cantidad);

        System.out.println("Valor de retorno: " + retorno);
        //El valor de retorno, debe ser cero (0) si termina sin ser detenido o uno(1) si termina a través de una de las señales registradas.
        System.exit(retorno);


    }

    static class CommandExecutor implements Runnable {
        private String comando;
        private String separador;
        private Map<String, String> entorno;

        public CommandExecutor(String comando, String separador, Map<String, String> entorno) {
            this.comando = comando;
            this.separador = separador;
            this.entorno = entorno;
        }

        //Cada hilo debe imprimir por la salida standar el comando y el valor de retorno, en formato “comando”separador “retorno”.
        @Override
        public void run() {
            try {
                String comandoCompleto = String.join(" ", comando.split(separador));
//                ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/C", comando); //ejecutar un comando en Windows (si es que no funciona bash -c comando)
                ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", comandoCompleto); //ejecutar un comando en Linux
                processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                processBuilder.environment().putAll(entorno);
                Process proceso = processBuilder.start();
                int valorRetorno = proceso.waitFor();

                // Imprimir el comando y el valor de retorno en el formato especificado
                System.out.printf("%s %s %d %n", comando, separador, valorRetorno);

                if (valorRetorno != 0) {
                    System.err.printf("El comando %s fallo con valor de retorno %d%n", comando, valorRetorno);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

