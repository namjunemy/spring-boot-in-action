package io.namjune.readinglist;

import io.namjune.readinglist.domain.Book;
import io.namjune.readinglist.domain.Reader;
import io.namjune.readinglist.repository.ReaderRepository;
import io.namjune.readinglist.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReaderRunner implements ApplicationRunner {

    private final ReaderRepository readerRepository;
    private final ReaderService readerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Reader tester = readerService.createReader("nj", "1234");
        Book book = Book.builder()
            .title("book1")
            .author("smith")
            .description("tester")
            .isbn("ko")
            .build();
        book.setReader(tester);
        tester.addBook(book);
        readerRepository.save(tester);
    }
}
