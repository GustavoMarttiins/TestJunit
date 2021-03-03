package com.generationtestetdd.SprintTDD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generationtestetdd.SprintTDD.models.ContatoModel;

public interface ContatoRepository  extends JpaRepository<ContatoModel, Long>{

}
