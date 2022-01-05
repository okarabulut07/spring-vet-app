package com.app.service;

import java.util.List;

import com.app.model.Animal;

public interface AnimalService {
	
	List<Animal> getAllAnimal();

	Animal getAnimalById(int id);

    void saveAnimal(Animal animal);

    void deleteAnimal(int id);

}
