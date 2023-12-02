/**
 * A classe `Departamento` representa um departamento no sistema de reserva de laboratórios da Ucsal.
 * Possui atributos como id, sigla, descrição e status.
 *
 * @author Bruno Casé e Zaira Dutra
 * @version 1.0
 * @since 21/11/2023
 */
package entities;

/**
 * Classe que representa um departamento.
 */
public class Departamento {

    // Atributos
    private long id;
    private String sigla;
    private String descricao;
    private boolean status;

    /**
     * Construtor da classe `Departamento`.
     *
     * @param id        O id do departamento.
     * @param sigla     A sigla do departamento.
     * @param descricao A descrição do departamento.
     * @param status    O status do departamento.
     */
    public Departamento(long id, String sigla, String descricao, boolean status) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
        this.status = status;
    }

    /**
     * Verifica o status do departamento.
     *
     * @return True se estiver ativo, false se estiver inativo.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Define o status do departamento.
     *
     * @param status O novo status do departamento.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Obtém a descrição do departamento.
     *
     * @return A descrição do departamento.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do departamento.
     *
     * @param descricao A nova descrição do departamento.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o id do departamento.
     *
     * @return O id do departamento.
     */
    public long getId() {
        return id;
    }

    /**
     * Define o id do departamento.
     *
     * @param id O novo id do departamento.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtém a sigla do departamento.
     *
     * @return A sigla do departamento.
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * Define a sigla do departamento.
     *
     * @param sigla A nova sigla do departamento.
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * Representação textual do departamento.
     *
     * @return Uma string representando o departamento.
     */
    @Override
    public String toString() {
        return "Departamento{" +
                " descricao='" + descricao + '\'' +
                '}';
    }
}
