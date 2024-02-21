package com.recargaGelsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.recargaGelsa.management_person.dao.IPersonRepository;
import com.recargaGelsa.management_person.entity.PersonEntity;
import com.recargaGelsa.recharge_management.dao.IOperatorRepository;
import com.recargaGelsa.recharge_management.entity.OperatorEntity;

@SpringBootApplication
public class RecargaGelsaApplication {
	
	 private final IPersonRepository personRepository;
	 private final IOperatorRepository operatorRepository;

	    @Autowired
	    public RecargaGelsaApplication(IPersonRepository personRepository,IOperatorRepository operatorRepository) {
	        this.personRepository = personRepository;
	        this.operatorRepository = operatorRepository;
	    }

	    public static void main(String[] args) {
	        SpringApplication.run(RecargaGelsaApplication.class, args);
	    }

	    @Autowired 
	    public void run() {
	        // Crear y guardar PersonEntitys
	        PersonEntity person1 = PersonEntity.builder()
	                .name("Juan")
	                .lastname("ortiz")
	                .dni("1234567")
	                .build();
	        personRepository.save(person1);

	        PersonEntity person2 = PersonEntity.builder()
	                .name("Maria")
	                .lastname("Smith")
	                .dni("9654321")
	                .build();
	        personRepository.save(person2);

	        PersonEntity person3 = PersonEntity.builder()
	                .name("Ana")
	                .lastname("Smith")
	                .dni("765431")
	                .build();
	        personRepository.save(person3);
	        
	        
	        OperatorEntity operator1 = OperatorEntity.builder()
	                .description("Tigo")
	                .build();
	        operatorRepository.save(operator1);

	        OperatorEntity operator2 = OperatorEntity.builder()
	                .description("Movistar")
	                .build();
	        operatorRepository.save(operator2);

	        OperatorEntity operator3 = OperatorEntity.builder()
	                .description("Comcel")
	                .build();
	        operatorRepository.save(operator3);

	        OperatorEntity operator4 = OperatorEntity.builder()
	                .description("Uff")
	                .build();
	        operatorRepository.save(operator4);
	    }

}
