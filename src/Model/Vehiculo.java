package Model;

public class Vehiculo {
    private String placa;
    private String estado;
    private boolean haSalido;

    public Vehiculo(String placa) {
        this.placa = placa;
        estado = "Permitido";
        haSalido = true;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isHaSalido() {
        return haSalido;
    }

    public void setHaSalido(boolean haSalido) {
        this.haSalido = haSalido;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", estado='" + estado + '\'' +
                ", haSalido=" + haSalido +
                '}';
    }
}
