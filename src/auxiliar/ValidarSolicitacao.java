package auxiliar;

import java.time.LocalTime;

public class ValidarSolicitacao {
    private boolean permitido = true;
    public boolean isPermitido() {
        return permitido;
    }


    public Boolean checarConflito(Solicitacao solicitacao, Reserva reserva){

            if (solicitacao.getProfessor() == reserva.getSolicitacao().getProfessor()) {

                if (solicitacao.getData().equals(reserva.getSolicitacao().getData())) {// Se as data da nova solicitacao for igual a de uma reserva cheque:

                    LocalTime horarioInicioNovaSolicitacao = solicitacao.getHorario();
                    LocalTime horarioFimNovaSolicitacao = horarioInicioNovaSolicitacao.plus(solicitacao.getTempo());

                    LocalTime horarioInicioReservaExistente = reserva.getSolicitacao().getHorario();
                    LocalTime horarioFimReservaExistente = horarioInicioReservaExistente.plus(reserva.getSolicitacao().getTempo());

                    if (horarioFimNovaSolicitacao.isBefore(horarioInicioReservaExistente) ||// se os períodos que duram a reserva não entram em choque
                            horarioInicioNovaSolicitacao.isAfter(horarioFimReservaExistente)) {
                        // Não há conflito, pode prosseguir com a nova solicitação

                         permitido = true;
                    } else {
                        // Há conflito, a nova solicitação não pode ser agendada
                         permitido = false;
                    }
                }
            }


            if (solicitacao.getLaboratorio() == reserva.getSolicitacao().getLaboratorio()) {// Se os laboratorios forem iguais cheque:

                if (solicitacao.getProfessor() == reserva.getSolicitacao().getProfessor()) {

                    if (solicitacao.getData().equals(reserva.getSolicitacao().getData())) {// Se as data da nova solicitacao for igual a de uma reserva cheque:

                        LocalTime horarioInicioNovaSolicitacao = solicitacao.getHorario();
                        LocalTime horarioFimNovaSolicitacao = horarioInicioNovaSolicitacao.plus(solicitacao.getTempo());

                        LocalTime horarioInicioReservaExistente = reserva.getSolicitacao().getHorario();
                        LocalTime horarioFimReservaExistente = horarioInicioReservaExistente.plus(reserva.getSolicitacao().getTempo());

                        if (horarioFimNovaSolicitacao.isBefore(horarioInicioReservaExistente) ||// se os períodos que duram a reserva não entram em choque
                                horarioInicioNovaSolicitacao.isAfter(horarioFimReservaExistente)) {
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


}
