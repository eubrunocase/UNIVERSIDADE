package auxiliar;

import entities.*;

import java.time.*;
import java.time.temporal.TemporalAmount;
import java.util.Set;

// Powered by: BRUNO CASÉ and ZAIRA DUTRA
//Last att: 12:58 pm  (21/11/2023)
public class Solicitacao {                 //ATRIBUTOS
    private int id;
    private Laboratorio laboratorio;
    private Professor professor;
    private Disciplina disciplina;
    private Set<Aluno> alunos;
    private LocalDate data;


    private LocalTime horario;
    private Duration tempo;

    public Solicitacao(int id, Laboratorio laboratorio, Professor professor, Disciplina disciplina, Aluno aluno, LocalDate data, Duration tempo) {    //CONSTRUTOR
        this.id = id;
        this.laboratorio = laboratorio;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.data = data;
        this.tempo = tempo;
    }

    public Solicitacao(){

    }


    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Set<Aluno> getAlunos(int capacidade) {                                //METODOS ACESSORES
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Duration getTempo() {
        return tempo;
    }

    public void setTempo(Duration tempo) {
        this.tempo = tempo;
    }

    private String formatarDuracao(Duration duration) {
        long horas = duration.toHours();
        long minutos = duration.toMinutesPart();

        return String.format("%d horas e %d minutos", horas, minutos);
    }

    public String toString() {                                   // METODO TO STRING
        return "sSolicitacao{" +
                "id=" + id +
                ", laboratorio=" + laboratorio +
                ", professor=" + professor +
                ", disciplina=" + disciplina +
                ", alunos=" + alunos +
                ", data='" + data + '\'' +
                ", tempo=" + formatarDuracao(tempo) +
                '}';
    }
}