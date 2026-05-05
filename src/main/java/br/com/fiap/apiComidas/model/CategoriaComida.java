package br.com.fiap.apiComidas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="categorias_comida")
public class CategoriaComida {

    @Id
    private Long id;
    private String nome;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    private String tipoCulinaria;
    private String restricaoAlimentar;

    public CategoriaComida() {
    }
}
