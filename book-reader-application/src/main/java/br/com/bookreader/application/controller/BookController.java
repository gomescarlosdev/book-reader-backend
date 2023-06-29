package br.com.bookreader.application.controller;

import br.com.bookreader.application.mapper.MMapperUtil;
import br.com.bookreader.application.request.UploadBookRequest;
import br.com.bookreader.application.response.BookResponse;
import br.com.bookreader.domain.entity.BookFileEntity;
import br.com.bookreader.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//controlador REST em Java que usa o Spring Framework
@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final IBookService bookService;

    @Autowired
    public BookController(
            IBookService bookService
    ) {
        this.bookService = bookService;
    }

    @GetMapping("/{customerId}")
    public List<BookResponse> getAllBooks(String customerId) {
        return bookService.findAllByCustomerId(customerId).stream()
                .map(entity -> MMapperUtil.getModelMapper().map(entity, BookResponse.class))
                .collect(Collectors.toList());
    } 
    //método usa o serviço bookService para buscar todos os livros que pertencem ao cliente e mapeia cada 
    //entidade de livro para uma resposta de livro usando o ModelMapper


    // faz upload de um arquivo de livro para o DB:
    @PostMapping("/{customerId}/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadFile(
            @PathVariable String customerId,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        UploadBookRequest uploadBookRequest = UploadBookRequest
                .builder()
                .customerId(customerId)
                .fileName(file.getOriginalFilename())
                .fileData(file.getBytes())
                .build();
        bookService.create(
                customerId,
                MMapperUtil.getModelMapper().map(uploadBookRequest, BookFileEntity.class)
        );
    }
 //O método cria um objeto UploadBookRequest com os dados do cliente e do arquivo e usa o serviço bookService para 
 //fazer upload do arquivo de livro para o DB

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFile(@PathVariable int id) {
        bookService.delete(id);
    }

}
