public class Aluno {                                             // Powered by: BRUNO CASÉ and ZAIRA DUTRA
                                                                  //Last att: 12:58 pm  (21/11/2023)
    private long id;
    private String nome;
    private long matricula;

    private boolean status;

    public Aluno(long id, String nome, long matricula, boolean status) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }




    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", status=" + status +
                '}';
    }
}
