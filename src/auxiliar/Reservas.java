package auxiliar;

import java.util.ArrayList;
import java.util.List;

public class Reservas {

    private List<Reserva> listaReservas;
    private List<Reserva> listaAprovadas;


    public Reservas() {
        this.listaReservas = new ArrayList<Reserva>();
        this.listaAprovadas = new ArrayList<Reserva>();
    }

    public List<Reserva> getListaAprovadas() {
        return listaAprovadas;
    }

    public void setListaAprovadas(List<Reserva> listaAprovadas) {
        this.listaAprovadas = listaAprovadas;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

}