import java.util.ArrayList;
                                                                            // Powered by: BRUNO CASÉ and ZAIRA DUTRA
                                                                            //Last att: 12:58 pm  (21/11/2023)
import java.util.List;

public class SolicitarLaboratorio {
    private List<Reserva> reservas;

    public SolicitarLaboratorio(List<Reserva> reservas) {                  // construtor
        this.reservas = reservas;
    }


    public void solicitarLaboratorio(Solicitacao solicitacao) {
        if (validarSolicitacao(solicitacao)) {
            Reserva reserva = new Reserva(solicitacao);
            reservas.add(reserva);
            System.out.println("Solicitação aprovada. Reserva efetuada com sucesso.");
        } else {
            System.out.println("Solicitação reprovada. Verifique os conflitos ou limite de reservas.");
        }
    }
    private boolean validarSolicitacao(Solicitacao solicitacao) {
        return true;
    }
}
