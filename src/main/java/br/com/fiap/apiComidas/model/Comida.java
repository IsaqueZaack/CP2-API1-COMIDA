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
@Table(name="comidas")
public class Comida {

    @Id
    private Long id;
    private String nome;
    private String ingredientes;
    @Column(name = "calorias", nullable = true)
    private String calorias;
    private String origem;

    public Comida() {
    }
}
