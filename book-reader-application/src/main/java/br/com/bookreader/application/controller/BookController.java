package br.com.bookreader.application.controller;

import br.com.bookreader.application.request.UploadBookRequest;
import br.com.bookreader.application.response.BookResponse;
import br.com.bookreader.domain.entity.BookFileEntity;
import br.com.bookreader.service.IBookService;
import org.modelmapper.ModelMapper;
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


@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final IBookService bookService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public BookController(
            IBookService bookService
    ) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> findAll(String customerId) {
        return bookService.findAll(customerId).stream()
                .map(bookModel -> modelMapper.map(bookModel, BookResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/favorites")
    public List<BookResponse> findFavorites(String customerId) {
        return bookService.findAllByIsFavorite(customerId).stream()
                .map(bookModel -> modelMapper.map(bookModel, BookResponse.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/{customerId}/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadFile(
            @PathVariable Integer customerId,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        UploadBookRequest uploadBookRequest = UploadBookRequest
                .builder()
                .customerId(customerId)
                .fileName(file.getOriginalFilename())
                .fileData(file.getBytes())
                .build();
        bookService.create(customerId, modelMapper.map(uploadBookRequest, BookFileEntity.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }

}
