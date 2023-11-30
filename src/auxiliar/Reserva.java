package auxiliar;

import entities.Disciplina;
import entities.Professor;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Reserva implements IReserva {                                                  // Powered by: BRUNO CASÉ and ZAIRA DUTRA
    //Last att: 12:58 pm  (21/11/2023)
    private int id;
    private Solicitacao solicitacao;

    private SituacaoReserva situacaoReserva;
    private LocalDateTime diaHoraReserva;
    private Duration duracao;
    private Professor professor;
    private Disciplina disciplina;



    private LocalDateTime dataLiberacao;


    public Reserva(Solicitacao solicitacao, Boolean valido,LocalDateTime diaHora, Duration duracao, Professor professor, Disciplina disciplina, LocalDateTime dataLiberacao) {

        this.id = solicitacao.getId();
        this.solicitacao = solicitacao;
        if (valido) {
            this.situacaoReserva = SituacaoReserva.APROVADA;
        } else {
            this.situacaoReserva = SituacaoReserva.REPROVADA;
        }
        this.diaHoraReserva = diaHora;
        this.duracao = duracao;
        this.professor = professor;
        this.disciplina = disciplina;
        this.dataLiberacao = dataLiberacao;
    }

    @Override
    public void Efetivar(Reserva reserva, List<Reserva> listaReservas) {
        if (reserva.situacaoReserva == SituacaoReserva.APROVADA) {
            listaReservas.add(reserva);
        }
    }




    public LocalDateTime dataLiberacao() {
        return dataLiberacao;
    }

    public LocalDateTime getDiaHoraReserva() {
        return diaHoraReserva;
    }

    public void setDiaHoraReserva(LocalDateTime diaHora) {
        this.diaHoraReserva = diaHora;
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
                ", situacao=" + situacaoReserva +
                ", solicitacao=" + solicitacao +
                ", diaDaReserva='" + diaHoraReserva + '\'' +
                ", duracao=" + duracao +
                '}';
    }



}

