package auxiliar;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Reserva implements IReserva {                                                  // Powered by: BRUNO CASÉ and ZAIRA DUTRA
    //Last att: 12:58 pm  (21/11/2023)
    private int id;
    private Solicitacao solicitacao;

    private SituacaoReserva situacaoReserva;
    private LocalDate diaDaReserva;
    private LocalTime horarioDaReserva;
    private Duration duracao;


    public Reserva(Solicitacao solicitacao, Boolean valido,LocalDate data, LocalTime horario, Duration duracao) {

        this.id = solicitacao.getId();
        if (valido) {
            this.situacaoReserva = SituacaoReserva.APROVADA;
        } else {
            this.situacaoReserva = SituacaoReserva.REPROVADA;
        }
        this.diaDaReserva = data;
        this.horarioDaReserva = horario;
        this.duracao = duracao;
    }






    public LocalDate getDiaDaReserva() {
        return diaDaReserva;
    }

    public void setDiaDaReserva(LocalDate diaDaReserva) {
        this.diaDaReserva = diaDaReserva;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SituacaoReserva getSituacao() {
        return situacaoReserva;
    }

    public void setSituacao(SituacaoReserva situacaoReserva) {
        this.situacaoReserva= situacaoReserva;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }


    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", solicitacao=" + solicitacao +
                ", situacao=" + situacaoReserva +
                ", diaDaReserva='" + diaDaReserva + '\'' +
                ", duracao=" + duracao +
                '}';
    }



}

