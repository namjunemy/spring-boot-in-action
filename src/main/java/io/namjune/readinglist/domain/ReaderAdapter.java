package io.namjune.readinglist.domain;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class ReaderAdapter extends User {

    private Reader reader;

    public ReaderAdapter(Reader reader) {
        super(reader.getUsername(), reader.getPassword(), authorities(reader.getRoles()));
        this.reader = reader;
    }

    // Account 의 role 정보를 가지고 authorities 정보를 만든다.
    private static Collection<? extends GrantedAuthority> authorities(Set<AccountRole> roles) {
        return roles.stream()
            .map(r -> new SimpleGrantedAuthority("ROLE_" + r.name()))
            .collect(Collectors.toSet());
    }

    public Reader getReader() {
        return reader;
    }
}
