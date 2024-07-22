package fr.it4innov.myasso.association.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.UUID;

@HttpExchange("/membre")
public interface MembreService {
    @GetExchange("/{id}")
    Object getPerson(@PathVariable UUID id);

    @PostExchange
    void add(@RequestBody Object membre);
}
