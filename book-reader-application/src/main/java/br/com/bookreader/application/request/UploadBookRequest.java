package br.com.bookreader.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UploadBookRequest {

    private String customerId;
    private String fileName;
    private byte[] fileData;

} //classe usada como um objeto de transferência de dados (DTO) para fazer upload de um livro
