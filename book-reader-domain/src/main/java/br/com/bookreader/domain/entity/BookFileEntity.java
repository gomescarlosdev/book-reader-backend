package br.com.bookreader.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter // injeta o método getter para cada atributo da classe
@Setter //injeta o método setter para cada atributo da classe
@NoArgsConstructor //injeta um construtor sem argumentos na classe
@AllArgsConstructor // injeta um construtor com todos os argumentos na classe
@EqualsAndHashCode //injeta os métodos equals() e hashCode() na classe
@Entity(name = "BOOK_FILE") // indica que essa classe é uma entidade JPA

//entidade em Java que usa o Lombok e o Spring Framework e representa um arquivo de livro e 
//tem quatro atributos: id, customerId, fileName e fileData
public class BookFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Lob
    @Column(name = "FILE_DATA")
    private byte[] fileData;

}
