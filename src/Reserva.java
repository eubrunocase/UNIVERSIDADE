import java.util.List;

public class Reserva implements IReserva{                                                  // Powered by: BRUNO CASÉ and ZAIRA DUTRA
                                                                                             //Last att: 12:58 pm  (21/11/2023)
    private int id;
    private Solicitacao solicitacao;
    private SituacaoReserva situacao;
    private String diaDaReserva;
    private int duracao;

    public Reserva(int id, Solicitacao solicitacao, SituacaoReserva situacao, String diaDaReserva, int duracao) {
        this.id = id;
        this.solicitacao = solicitacao;
        this.situacao = situacao;
        this.diaDaReserva = diaDaReserva;
        this.duracao = duracao;
    }

    public Reserva(Solicitacao solicitacao) {
    }

    public String getDiaDaReserva() {
        return diaDaReserva;
    }

    public void setDiaDaReserva(String diaDaReserva) {
        this.diaDaReserva = diaDaReserva;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SituacaoReserva getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoReserva situacao) {
        this.situacao = situacao;
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
                ", situacao=" + situacao +
                ", diaDaReserva='" + diaDaReserva + '\'' +
                ", duracao=" + duracao +
                '}';
    }


    public List<Reserva> getReservas() {
        return null;
    }
}
