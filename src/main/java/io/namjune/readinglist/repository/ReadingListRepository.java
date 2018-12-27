package io.namjune.readinglist.repository;

import io.namjune.readinglist.domain.Book;
import java.util.List;

import io.namjune.readinglist.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(Reader reader);
}
