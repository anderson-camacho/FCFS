public class Proceso {
    private int tiempoLlegada;
    private int tiempoInicioEjecucion;
    private int tiempoFinalizacionEjecucion;
    private int tiempoRequerido;
    private String nombre;
    private boolean ejecutado;

    public Proceso(int tiempoLlegada, int tiempoRequerido, String nombre) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoInicioEjecucion = 0;
        this.tiempoFinalizacionEjecucion = 0;
        this.tiempoRequerido = tiempoRequerido;
        this.ejecutado = false;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoInicioEjecucion() {
        return tiempoInicioEjecucion;
    }

    public void setTiempoInicioEjecucion(int tiempoInicioEjecucion) {
        this.tiempoInicioEjecucion = tiempoInicioEjecucion;
    }

    public int getTiempoFinalizacionEjecucion() {
        return tiempoFinalizacionEjecucion;
    }

    public void setTiempoFinalizacionEjecucion(int tiempoFinalizacionEjecucion) {
        this.tiempoFinalizacionEjecucion = tiempoFinalizacionEjecucion;
    }

    public int getTiempoRequerido() {
        return tiempoRequerido;
    }

    public void setTiempoRequerido(int tiempoRequerido) {
        this.tiempoRequerido = tiempoRequerido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEjecutado() {
        return ejecutado;
    }

    public void setEjecutado(boolean ejecutado) {
        this.ejecutado = ejecutado;
    }

    @Override
    public String toString() {
        return "Proceso: " + nombre + ", QLlegada: " + tiempoLlegada + ", QInicio: " + tiempoInicioEjecucion + ", QFinalización: "
                + tiempoFinalizacionEjecucion + ", QtiempoRequerido: " + tiempoRequerido + ", Ejecutado: " + ejecutado;
    }
}