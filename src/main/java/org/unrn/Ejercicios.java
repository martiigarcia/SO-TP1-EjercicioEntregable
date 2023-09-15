package org.unrn;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Ejercicios {

//    private static boolean releerArchivo = false;

    public static void main(String[] args) {

    }
}
//        //variables de entorno:
//        if (System.getenv(" PRUEBA ") != null) {
//            System.out.println(System.getenv(" PRUEBA "));
//        } else {
//            System.out.println("Prueba es vacio ");
//        }

//        //valor de retorno
//        System.out.println(" Hello World! ");
//        System.exit(0);
//
//        //argumentos de linea de comandos:
//        System.out.println(Arrays.toString(args));
//        for (String param : args) {
//            System.out.println(param);
//        }
//        System.exit(0);
//
//        //entrada / salida
//        try {
//            var stdin = new BufferedReader(
//                    new InputStreamReader(System.in));
//            var txt = stdin.readLine();
//            System.out.println(String.format("Por la salida %s", txt)); //.out es salida normal
//            System.err.println(String.format("Por los errores %s", txt)); //.err es salida de error en rojo
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //señales
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            try {
//                System.out.println("Señal recibida. Terminando...");
//                // Agregar aquí cualquier otra lógica que necesite ejecutarse antes de la terminación
//            } catch (InterruptedException e) {
//                // Manejar la excepción de InterruptedException si es necesario
//                e.printStackTrace();
//            }
//        }));

//TP - Ejercicio 1.1.1 (modificado para probar como anda)
//        String usuario = System.getenv("USERNAME"); //de prueba
//        String java_home = System.getenv("JAVA_HOME");//de prueba
//        String host = System.getenv("HOST");//de prueba
//        String dateFormat = System.getenv("DATE_FORMAT"); //variable fecha
//        String directorioActual = System.getProperty("user.dir"); //variable para saber directorio actual
//        String directorioHome = System.getProperty("user.home"); //variable apra saber direccion de HOME
//
//
//        if (usuario == null) {
//            System.err.println("USUARIO NO ESTA DEFINIDA");
//            System.exit(1);
//        }
//        System.out.println("Usuario: " + usuario);
//
//        if (java_home == null) {
//            System.err.println("JAVA_HOME NO ESTA DEFINIDA");
//            System.exit(1);
//        }
//        System.out.println("Java Home: " + java_home);
//
//        if (host == null) {
//            System.err.println("HOST NO ESTA DEFINIDA");
////            System.exit(1);
//        }
////        System.out.println("Host: " + host);
//
//        //TP - ejercicio 1.1.2 y 1.2.1
//        if (dateFormat == null) {
//            System.err.println("DATE_FORMAT NO ESTA DEFINIDA");
//            dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
////            System.exit(1);
//        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
//        String fechaYHora = simpleDateFormat.format(new Date());
//        System.out.println("Fecha y Hora: " + fechaYHora);
//
//
//        //TP - Ejercicio 1.2.2
//        if (directorioActual.startsWith(directorioHome)) {
//            System.out.println("El directorio actual esta dentro del directorio HOME.");
//        } else {
//            System.err.println("El directorio actual no esta dentro del directorio HOME.");
////            System.exit(1);
//        }
//        System.out.println("DIR ACTUAL: " + directorioActual);
//        System.out.println("DIR HOME: " + directorioHome);


////        Ejercicio 1.4.1 Calculadora
//        //Comando para que funcione: java Ejercicios.java -op1 "1" -op2 "3" -op "+"
//        if (args.length != 6 || !args[0].equals("-op1") || !args[2].equals("-op2") || !args[4].equals("-op")) {
//            System.err.println("Falta ingresar parametros");
//            System.exit(1);
//        }
//
//        double operando1 = Double.parseDouble(args[1]);
//        double operando2 = Double.parseDouble(args[3]);
//        String operador = args[5];
//
//        System.out.println("ARGUMENTO 1: " + operando1);
//        System.out.println("ARGUMENTO 2: " + operando2);
//        System.out.println("OPERADOR: " + operador);
//
//        double resultado = 0.0;
//        try {
//            switch (operador) {
//                case "+":
//                    resultado = operando1 + operando2;
//                    break;
//                case "-":
//                    resultado = operando1 - operando2;
//                    break;
//                case "*":
//                    resultado = operando1 * operando2;
//                    break;
//                case "/":
//                    if (operando2 != 0) {
//                        resultado = operando1 / operando2;
//                    } else {
//                        System.err.println("Error: División por cero.");
//                        System.exit(1);
//                    }
//                    break;
//                default:
//                    System.err.println("Error: Operador no válido. Use +, -, *, o /.");
//                    System.exit(1);
//            }
//
//            // Imprimir el resultado por la salida estándar
//            System.out.println("Resultado: " + resultado);
//        } catch (NumberFormatException e) {
//            // Manejar errores de conversión de números
//            System.err.println("Error: Los operandos deben ser números válidos.");
//            System.exit(1);
//        }


//        //Ejercicio 1.4.2
//        if (!args[0].equals("-cadena")) {
//            System.err.println("Uso: java ContadorCaracteres <cadena>");
//            System.exit(1);
//        }
//        String text = args[0];
//        int cantidadMinima = text.length();
//
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String linea;
//
//            while ((linea = br.readLine()) != null) {
//                int cantidadCaracteres = linea.length();
//
//                if (cantidadCaracteres >= cantidadMinima) {
//                    // Imprimir la cantidad de caracteres en la salida estándar
//                    System.out.println(cantidadCaracteres);
//                } else {
//                    // Imprimir un mensaje de error en la salida de errores
//                    System.err.println("Error: La línea tiene menos de " + cantidadMinima + " caracteres.");
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error al leer la entrada estándar: " + e.getMessage());
//            System.exit(1);
//        }


//        //Ejercicio 1.5.1 : Señales
//        // Registrar manejadores de señales INT y TERM
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("Señal recibida. Terminando...");
//        }));
//
//        while (true) {
//            // Procesar líneas de texto cada segundo
//            // ...
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


//        //Ejercicio 1.5.2
//        if (!args[0].equals("-archivo")) {
//            System.err.println("Uso: java Ejercicios <archivo>");
//            System.exit(1);
//        }
//
//
//        String nombreArchivo = args[1];
//        System.out.println("ARCHIVO: " + args[1]);
//
//        // Registrar manejadores de señales INT y TERM
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("Señal recibida. Terminando...");
//        }));
//
//        // Crear un temporizador para procesar líneas de texto cada segundo
//        Timer timer = new Timer();
//        TimerTask tarea = new TimerTask() {
//            @Override
//            public void run() {
////                procesarLineasDeTexto();
//                while (true) {
//                    leerArchivo(nombreArchivo);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        // Programar la tarea para ejecutarse cada 1000 milisegundos (1 segundo)
//        timer.scheduleAtFixedRate(tarea, 0, 1000);


//        //Ejercicio 1.6.1
//        Random random = new Random();
//        int valorAleatorio = random.nextInt(1000);
//        System.out.println(valorAleatorio);
//        String comando = "echo $" + valorAleatorio;
//        System.out.println(comando);
//
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", comando);
//            processBuilder.environment().put("VARIABLE", String.valueOf(valorAleatorio));
//            Process proceso = processBuilder.start();
//            int estadoDeSalida = proceso.waitFor();
//            System.out.println("Resultado del comando: " + estadoDeSalida);
//        } catch (IOException | InterruptedException e) {
//            System.err.println("Error al ejecutar el comando: " + e.getMessage());
//            System.exit(1);
//        }


////        Ejercicio 1.6.2
//        if (!args[0].equals("-comando")) {
//            System.err.println("Uso: java Ejercicios <archivo>");
//            System.exit(1);
//        }
//        String comando = args[1];
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", comando);
//            Process proceso = processBuilder.start();
//            int estadoDeSalida = proceso.waitFor();
//
//            if (estadoDeSalida == 0) {
//                System.out.println("Ejecución correcta");
//            } else {
//                System.err.println("Ejecución incorrecta");
//            }
//
//            System.exit(estadoDeSalida);
//        } catch (IOException | InterruptedException e) {
//            System.err.println("Error al ejecutar el comando: " + e.getMessage());
//            System.exit(1);
//        }

////        Ejercicio 1.7.1
//        Runnable hilo1 = new ImprimirHilo(1);
//        Runnable hilo2 = new ImprimirHilo(2);
//        Thread thread1 = new Thread(hilo1);
//        Thread thread2 = new Thread(hilo2);
//        thread1.start();
//        thread2.start();
//    }
//}
//
//class ImprimirHilo implements Runnable {
//    private int numeroHilo;
//
//    public ImprimirHilo(int numeroHilo) {
//        this.numeroHilo = numeroHilo;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Soy el hilo " + numeroHilo);
//    }


//        // Ejercicio 1.7.2
//        if (args.length != 3) {
//            System.err.println("Uso: java BuscarArchivoEnHilos <nombre_archivo> <directorio1> <directorio2>");
//            System.exit(1);
//        }
//
//        String nombreArchivo = args[0];
//        String directorio1 = args[1];
//        String directorio2 = args[2];
//        // Crear e iniciar los hilos
//        Thread hilo1 = new Thread(new BuscadorArchivo(nombreArchivo, directorio1));
//        Thread hilo2 = new Thread(new BuscadorArchivo(nombreArchivo, directorio2));
//        hilo1.start();
//        hilo2.start();
//
////C:\Users\marti\OneDrive\Escritorio\trabajos-actuales\sistemas-operativos\tp1\ejercicio-entregable\ejercicio_entregable\src\main\resources\test-text.txt
//        // Esperar a que ambos hilos terminen
//        try {
//            hilo1.join();
//            hilo2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Búsqueda completada en ambos directorios.");
//    }
//}
//
//class BuscadorArchivo implements Runnable {
//    private String nombreArchivo;
//    private String directorio;
//
//    public BuscadorArchivo(String nombreArchivo, String directorio) {
//        this.nombreArchivo = nombreArchivo;
//        this.directorio = directorio;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Buscando " + nombreArchivo + " en " + directorio + "...");
//        int resultado = ejecutarComandoFind(nombreArchivo, directorio);
//        if (resultado == 0) {
//            System.out.println("Encontré el " + nombreArchivo + " en " + directorio);
//        } else {
//            System.out.println("No encontré el " + nombreArchivo + " en " + directorio);
//        }
//    }
//    private int ejecutarComandoFind(String nombreArchivo, String directorio) {
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder("dir", directorio, "-name", nombreArchivo);
//            Process proceso = processBuilder.start();
//            int estadoDeSalida = proceso.waitFor();
//            return estadoDeSalida;
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            return -1; // Error
//        }
//    }
//}


//        System.exit(0);


//    private static void leerArchivo(String nombreArchivo) {
//        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
//            String linea;
//            while ((linea = br.readLine()) != null) {
//                // Procesar la línea de texto (simplemente imprimirla en este ejemplo)
//                System.out.println(linea);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//}