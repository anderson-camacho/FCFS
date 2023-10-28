import jdk.jfr.Timestamp;

import java.util.*;

public class Fcfs {

    Queue<Proceso> colaDeListos = new LinkedList<>();
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    int time = 0;
    boolean imprimrListaFlag = false;

    int numeroProcesosAgragaods = 0;

    public void ejecucion() {
        this.colaDeListos.add(crearProceso(0));
        System.out.println("--->LOG:Iniciamos el SO, se prendio esta joda");
        for (int i = 0; i < 9; i++) {
            this.colaDeListos.add(crearProceso(i + rand.nextInt(10)));
        }
        ordenarLista();
        ingresarDatos();
        imprimrListaFlag = true;
        imprimirColaListos();
        procesador();

        while (true) {
            espera(1, "Ejecucion General");
            ordenarLista();
            imprimirColaListos();

        }
    }

    public void procesador() {
        System.out.println("--->LOG:Proceso de Ingresar datos activado");
        Thread thread = new Thread(() -> {
            for (Proceso proceso : colaDeListos) {
                System.out.println("Se inicia el proceso " + proceso.getNombre());
                if (proceso.getNombre().equals("P1")) {
                    proceso.setTiempoInicioEjecucion(this.time - 1);
                } else {
                    proceso.setTiempoInicioEjecucion(this.time);
                }
                System.out.println("El proceso" + proceso.getNombre() + "tiene los sigueintes datos.");
                System.out.println(proceso);

                try {
                    Thread.sleep((long) 1000 * (proceso.getTiempoRequerido()) + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                proceso.setTiempoFinalizacionEjecucion(this.time);
                proceso.setEjecutado(true);

                System.out.println("El proceso" + proceso.getNombre() + "termina con los sigueintes datos.");
                System.out.println(proceso);
            }
        });
        thread.start();
    }

    public void ingresarDatos() {
        System.out.println("--->LOG:Proceso de Ingresar datos activado");
        Thread thread = new Thread(() -> {
            boolean flag = true;
            while (flag) {

                System.out.println("Pon cualquier letra y luego presiona enter en cualquier momento para agregar un prcoeso excepto con la x la x apaga la entrada de datos");
                String input = scanner.nextLine();
                espera(1, "Ingreso de datos");
                if (!input.equals("X")) {
                    this.colaDeListos.add(crearProceso());
                    this.imprimrListaFlag = true;
                    input = "X";
                    System.out.println("--->LOG:Listo agregado.");
                } else {
                    System.out.println("--->LOG:Intentalo de nuevo.");
                    flag = false;
                }
            }
        });
        thread.start();
    }

    public void espera(int segundos, String msg) {
        System.out.println("Proceso: " + msg);
        try {
            this.time++;
            System.out.println("Tiempo actual: " + this.time);
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void imprimirColaListos() {
        if (this.imprimrListaFlag) {
            System.out.println("Lista Actual de Cola de listos");
            System.out.println("------------------------------------");
            for (Proceso proceso : this.colaDeListos) {
                System.out.println(proceso.toString());
            }
            System.out.println("------------------------------------");
            imprimrListaFlag = false;
        }
    }

    public Proceso crearProceso() {
        System.out.println("------------------------------------");
        System.out.println("--->LOG: Creando Proceso");
        this.numeroProcesosAgragaods++;
        Proceso proceso = new Proceso(time + rand.nextInt(20) + 10,
                rand.nextInt(10) + 1, "P" + this.numeroProcesosAgragaods);
        System.out.println(proceso.toString());
        System.out.println("------------------------------------");
        return proceso;
    }

    public Proceso crearProceso(int tiempollegada) {
        System.out.println("------------------------------------");
        System.out.println("--->LOG: Creando Proceso");
        this.numeroProcesosAgragaods++;
        Proceso proceso = new Proceso(tiempollegada, rand.nextInt(10) + 1, "P" + this.numeroProcesosAgragaods);
        System.out.println(proceso.toString());
        System.out.println("------------------------------------");
        return proceso;
    }

    public void verProcesos() {
        System.out.println("------------------------------------");
        for (Proceso proceso : this.colaDeListos) {
            System.out.println(proceso.toString());
        }
        System.out.println("------------------------------------");
    }

    public void ordenarLista() {
        Collections.sort((LinkedList<Proceso>) colaDeListos, new Comparator<Proceso>() {
            @Override
            public int compare(Proceso proceso1, Proceso proceso2) {
                return Integer.compare(proceso1.getTiempoLlegada(), proceso2.getTiempoLlegada());
            }
        });
    }
}
