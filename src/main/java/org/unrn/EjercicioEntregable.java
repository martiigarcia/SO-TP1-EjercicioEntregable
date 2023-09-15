package org.unrn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjercicioEntregable {

    private static volatile boolean terminar = false;
    private static int cantidad = 0;
    private static List<Thread> threads = new ArrayList<>();
    public static int retorno = 0;

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Señal recibida. Terminando...");
            retorno = 1;
            terminar = true;
        }));

        String separador = "\t";
        if (args.length > 0 && args[0].equals("-s"))
            separador = args[1];

        Map<String, String> entorno = new HashMap<>(System.getenv());
        entorno.put("HOSTNAME", "prueba");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;
            System.out.printf("Ingrese comandos e ingrese enter.%n" +
                    "*Para terminar seleccione enter dos veces o finalice con señales INT o TERM con las teclas Ctrl+C (Windows), " +
                    "Ctrol+Z+Enter (Windows), Ctrol+D (Linux)%n");
            while (!terminar) {
                linea = reader.readLine();


                if (linea == null || linea.isBlank()) {
                    terminar = true;
                } else {
                    cantidad++;
                    Thread thread = new Thread(new CommandExecutor(linea.replaceAll(separador, ""), separador, entorno));
                    threads.add(thread);
                    thread.start();
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
        System.out.println("Cantidad de Comandos/lineas leidas: " + cantidad);

        System.out.println("Valor de retorno: " + retorno);
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

        @Override
        public void run() {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", comando);
//                processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                processBuilder.environment().putAll(entorno);
                Process proceso = processBuilder.start();
                int valorRetorno = proceso.waitFor();

                System.out.printf("Resultado-> %s%s %d %n", comando, separador, valorRetorno);

                if (valorRetorno != 0) {
                    System.err.printf("El comando %s fallo con valor de retorno %d%n", comando, valorRetorno);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

