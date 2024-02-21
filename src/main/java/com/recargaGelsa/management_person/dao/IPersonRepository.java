package com.recargaGelsa.management_person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recargaGelsa.management_person.entity.PersonEntity;

public interface IPersonRepository extends JpaRepository<PersonEntity, Integer> {

}
