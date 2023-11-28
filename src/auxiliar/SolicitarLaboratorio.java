package auxiliar;

// Powered by: BRUNO CASÉ and ZAIRA DUTRA
//Last att: 12:58 pm  (21/11/2023)
import application.Base;
import entities.Departamento;
import entities.Disciplina;
import entities.Laboratorio;
import entities.Professor;

import java.util.List;
import java.util.Scanner;



public class SolicitarLaboratorio {
    private List<Reserva> reservas;

    private Base bd;

    public SolicitarLaboratorio(Base bd) {                  // construtor
        this.reservas = reservas;
        this.bd = bd;
    }


    public void solicitarLaboratorio(Solicitacao solicitacao) {
        if (validarSolicitacao(solicitacao)) {
            Reserva reserva = new Reserva(solicitacao);
            reservas.add(reserva);
            System.out.println("Solicitação aprovada. auxiliar.Reserva efetuada com sucesso.");
        } else {
            System.out.println("Solicitação reprovada. Verifique os conflitos ou limite de reservas.");
        }
    }
    private boolean validarSolicitacao(Solicitacao solicitacao) {
        return true;
    }

    public void solicitarLaboratorio(){
        Scanner ler = new Scanner(System.in);

        List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        System.out.println(disciplinas);
        System.out.println();
        System.out.println(departamentos);
        System.out.println();
        System.out.println(laboratorios);
        System.out.println();
        System.out.println(professores);

    }

}
