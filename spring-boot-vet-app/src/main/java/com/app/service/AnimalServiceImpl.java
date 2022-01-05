package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Animal;
import com.app.repo.AnimalRepository;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	AnimalRepository repository;
	
	@Override
	public List<Animal> getAllAnimal() {
		return (List<Animal>) repository.findAll();
	}

	@Override
	public Animal getAnimalById(int id) {
		
		return repository.findById(id).get();
		
	}

	@Override
	public void saveAnimal(Animal animal) {
		repository.save(animal);
		
	}

	@Override
	public void deleteAnimal(int id) {
		
		repository.deleteById(id);
		
	}

}
