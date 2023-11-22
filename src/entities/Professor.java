package entities;

import java.util.List;
public class Professor {                                              // Powered by: BRUNO CASÉ and ZAIRA DUTRA
                                                                        //Last att: 12:58 pm  (21/11/2023)
    private long id;
    private String nome;                                               //ATRIBUTOS
    private boolean status;
    private Departamento departamento;
    private List<Disciplina> Disciplina;

    public Professor(boolean ativo, long id, String nome, Departamento departamento, Disciplina disciplina) {  //CONSTRUTOR
        this.status = ativo;
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.Disciplina = Disciplina;
    }

    public Departamento getDepartamento() {                                     //METODOS ACESSORES E MODIFICADORES
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Disciplina> getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        Disciplina = disciplina;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean ativo) {
        this.status = ativo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String toString() {
        return "entities.Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", departamento=" + departamento +
                ", entities.Disciplina=" + Disciplina +
                '}';
    }
}
