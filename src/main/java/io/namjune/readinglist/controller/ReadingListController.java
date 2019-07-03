package io.namjune.readinglist.controller;

import io.namjune.readinglist.annotation.CurrentUser;
import io.namjune.readinglist.controller.dto.BookRequestDTO;
import io.namjune.readinglist.domain.Book;
import io.namjune.readinglist.domain.Reader;
import io.namjune.readinglist.repository.ReaderRepository;
import io.namjune.readinglist.repository.ReadingListRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ReadingListController {

    private final ReadingListRepository readingListRepository;
    private final ReaderRepository readerRepository;
    private final ModelMapper modelMapper;

    @GetMapping
    public String readersBooks(@CurrentUser Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
        }
        return "readingList";
    }

    @PostMapping
    public String addToReadingList(@CurrentUser Reader reader, BookRequestDTO bookDTO) {
        Book book = this.modelMapper.map(bookDTO, Book.class);
        book.setReader(reader);
        readingListRepository.save(book);
        reader.addBook(book);
        readerRepository.save(reader);
        return "redirect:/";
    }
}
