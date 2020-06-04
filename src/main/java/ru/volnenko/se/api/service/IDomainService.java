package ru.volnenko.se.api.service;

import ru.volnenko.se.entity.Domain;

/**
 * @author Denis Volnenko
 */
public interface IDomainService {

    void load(Domain domain);

    void export(Domain domain);

}
