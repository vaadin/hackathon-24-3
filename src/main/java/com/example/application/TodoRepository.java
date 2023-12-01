package com.example.application;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import com.github.mcollovati.quarkus.hilla.crud.panache.FilterableRepository;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<Todo>, FilterableRepository<Todo, Long> {
}