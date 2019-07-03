package io.namjune.readinglist.service;

import io.namjune.readinglist.domain.AccountRole;
import io.namjune.readinglist.domain.Reader;
import io.namjune.readinglist.domain.ReaderAdapter;
import io.namjune.readinglist.repository.ReaderRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReaderService implements UserDetailsService {

    private final ReaderRepository readerRepository;
    private final PasswordEncoder passwordEncoder;

    public Reader createReader(String username, String password) {
        Reader reader = Reader.builder()
            .username(username)
            .fullname(username)
            .password(passwordEncoder.encode(password))
            .roles(Stream.of(AccountRole.ADMIN, AccountRole.USER).collect(Collectors.toSet()))
            .build();
        return readerRepository.save(reader);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Reader reader = readerRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(username));
        return new ReaderAdapter(reader);
    }
}
