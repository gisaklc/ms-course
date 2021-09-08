package com.devsuperior.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;

	public List<Worker> findAll() {
		List<Worker> list = workerRepository.findAll();
		return list;

	}

	public Worker findById(Long id) throws ObjectNotFoundException {
		Optional<Worker> worker = workerRepository.findById(id);
		return worker.orElseThrow(() -> new ObjectNotFoundException(
				"Worker não encontrado! Id: " + id + ", Tipo: " + Worker.class.getName()));
	}

}
