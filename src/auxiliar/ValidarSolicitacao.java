package auxiliar;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ValidarSolicitacao {
    private boolean permitido = true;



    public Boolean checarConflito(Solicitacao solicitacao, List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (solicitacao.getProfessor() == reserva.getSolicitacao().getProfessor()) {
                if (solicitacao.getDataHora().toLocalDate().equals(reserva.getSolicitacao().getDataHora().toLocalDate())) {
                    // Se as datas da nova solicitação forem iguais às de uma reserva, verifique os horários
                    LocalDateTime inicioNovaSolicitacao = solicitacao.getDataHora();
                    LocalDateTime fimNovaSolicitacao = inicioNovaSolicitacao.plus(solicitacao.getTempo());

                    LocalDateTime inicioReservaExistente = reserva.getSolicitacao().getDataHora();
                    LocalDateTime fimReservaExistente = inicioReservaExistente.plus(reserva.getSolicitacao().getTempo());

                    if (fimNovaSolicitacao.isBefore(inicioReservaExistente) ||
                            inicioNovaSolicitacao.isAfter(fimReservaExistente)) {
                        // Não há conflito, pode prosseguir com a nova solicitação
                        permitido = true;
                    } else {
                        // Há conflito, a nova solicitação não pode ser agendada
                        permitido = false;
                    }
                }
            }

            if (solicitacao.getLaboratorio() == reserva.getSolicitacao().getLaboratorio()) {
                if (solicitacao.getDataHora().toLocalDate().equals(reserva.getSolicitacao().getDataHora().toLocalDate())) {
                    // Se as datas da nova solicitação forem iguais às de uma reserva, verifique os horários
                    LocalDateTime inicioNovaSolicitacao = solicitacao.getDataHora();
                    LocalDateTime fimNovaSolicitacao = inicioNovaSolicitacao.plus(solicitacao.getTempo());

                    LocalDateTime inicioReservaExistente = reserva.getSolicitacao().getDataHora();
                    LocalDateTime fimReservaExistente = inicioReservaExistente.plus(reserva.getSolicitacao().getTempo());

                    if (fimNovaSolicitacao.isBefore(inicioReservaExistente) ||
                            inicioNovaSolicitacao.isAfter(fimReservaExistente)) {
                        // Não há conflito, pode prosseguir com a nova solicitação
                        permitido = true;
                    } else {
                        // Há conflito, a nova solicitação não pode ser agendada
                        permitido = false;
                    }
                }
            }
        }
        return isPermitido();
    }

    public boolean isPermitido() {
        return permitido;
    }
}
