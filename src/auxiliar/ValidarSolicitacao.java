package auxiliar;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ValidarSolicitacao {
    private boolean permitido = true;

    public boolean checarConflito(Solicitacao solicitacao, List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (solicitacao.getProfessor().equals(reserva.getSolicitacao().getProfessor())) {
                verificarConflito(solicitacao, reserva.getSolicitacao());
            }

            if (solicitacao.getLaboratorio().equals(reserva.getSolicitacao().getLaboratorio())) {
                verificarConflito(solicitacao, reserva.getSolicitacao());
            }
        }
        return isPermitido();
    }

    private void verificarConflito(Solicitacao novaSolicitacao, Solicitacao existente) {
        if (novaSolicitacao.getDataHora().toLocalDate().equals(existente.getDataHora().toLocalDate())) {
            LocalDateTime inicioNovaSolicitacao = novaSolicitacao.getDataHora();
            LocalDateTime fimNovaSolicitacao = inicioNovaSolicitacao.plus(novaSolicitacao.getTempo());

            LocalDateTime inicioReservaExistente = existente.getDataHora();
            LocalDateTime fimReservaExistente = inicioReservaExistente.plus(existente.getTempo());

            if (fimNovaSolicitacao.isBefore(inicioReservaExistente) || inicioNovaSolicitacao.isAfter(fimReservaExistente)) {
                permitido = true;
            } else {
                permitido = false;
            }
        }
    }

    public boolean isPermitido() {
        return permitido;
    }
}