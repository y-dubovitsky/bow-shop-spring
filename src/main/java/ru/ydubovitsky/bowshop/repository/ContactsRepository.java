package ru.ydubovitsky.bowshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.bowshop.entity.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {
}
