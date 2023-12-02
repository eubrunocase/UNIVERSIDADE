/**
 * A classe `Laboratorio` representa um laboratório no sistema de reserva de laboratórios da Ucsal.
 * Possui atributos como id, descrição, capacidade e status.
 *
 * @author Bruno Casé e Zaira Dutra
 * @version 1.0
 * @since 21/11/2023
 */
package entities;

/**
 * Classe que representa um laboratório.
 */
public class Laboratorio {

    // Atributos
    private int id;
    private String descricao;
    private int capacidade;
    private boolean status;

    /**
     * Construtor da classe `Laboratorio`.
     *
     * @param id         O id do laboratório.
     * @param descricao  A descrição do laboratório.
     * @param capacidade A capacidade do laboratório.
     * @param status     O status do laboratório.
     */
    public Laboratorio(int id, String descricao, int capacidade, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.status = status;
    }

    /**
     * Obtém a capacidade do laboratório.
     *
     * @return A capacidade do laboratório.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Define a capacidade do laboratório.
     *
     * @param capacidade A nova capacidade do laboratório.
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * Obtém a descrição do laboratório.
     *
     * @return A descrição do laboratório.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do laboratório.
     *
     * @param descricao A nova descrição do laboratório.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o id do laboratório.
     *
     * @return O id do laboratório.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o id do laboratório.
     *
     * @param id O novo id do laboratório.
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Verifica se o laboratório está ativo.
     *
     * @return True se estiver ativo, false se estiver inativo.
     */
    public boolean isStatus() {

        return status;
    }

    /**
     * Define o status do laboratório.
     *
     * @param status O novo status do laboratório.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Representação textual do laboratório.
     *
     * @return Uma string representando o laboratório.
     */
    @Override
    public String toString() {
        return "Laboratorio[id=" + id + ", descricao=" + descricao + ", capacidade=" + capacidade + ", status=" + status + "]";
    }
}
