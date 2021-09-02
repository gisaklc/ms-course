package com.devsuperior.hrworker.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.services.WorkerService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerService workService;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workService.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) throws ObjectNotFoundException {
		Worker worker = workService.findById(id);
		return ResponseEntity.ok().body(worker);
	}

}
