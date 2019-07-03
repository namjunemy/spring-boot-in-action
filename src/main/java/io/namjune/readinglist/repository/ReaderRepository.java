package io.namjune.readinglist.repository;

import io.namjune.readinglist.domain.Reader;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Optional<Reader> findByUsername(String username);
}
