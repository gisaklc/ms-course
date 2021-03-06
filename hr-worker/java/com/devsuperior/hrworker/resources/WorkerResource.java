package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.services.WorkerService;

import javassist.tools.rmi.ObjectNotFoundException;

@RefreshScope //atualiza as configurações em RUNTIME
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Autowired
	private WorkerService workService;

	/**
	 * 
	 * Tem varias inf do contexto da aplicacao
	 **/
	@Autowired
	private Environment env;

	@Value("${test.config}")
	private String testConfig;

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("Config = " + testConfig);
		logger.info("TESTE" );
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workService.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) throws ObjectNotFoundException {
//
		try {
			Thread.sleep(3000L);// temp de 3 segundos p/ timout
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*** imprimir o numero da porta rodando **/
		logger.info("PORT = " + env.getProperty("local.server.port"));
		Worker worker = workService.findById(id);
		return ResponseEntity.ok().body(worker);
	}

}
