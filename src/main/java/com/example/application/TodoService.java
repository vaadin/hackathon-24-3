package com.example.application;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;

import com.github.mcollovati.quarkus.hilla.crud.panache.CrudRepositoryService;

@BrowserCallable
@AnonymousAllowed
public class TodoService extends CrudRepositoryService<Todo, Long, TodoRepository> {
}
