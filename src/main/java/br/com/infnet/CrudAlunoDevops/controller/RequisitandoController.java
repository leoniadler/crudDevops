//package br.com.infnet.CrudAlunoDevops.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.infnet.CrudAlunoDevops.model.Retorno;
//
//@RestController
//@RequestMapping( "/requisitando")
//public class RequisitandoController {
//	@Value("${mensagem.requisicao}")
//	private String mensagem;
//	
//	private static final Logger LOG = LoggerFactory.getLogger(RequisitandoController.class);
//	
//	@GetMapping
//	public ResponseEntity<Retorno> requisitando(){
//		LOG.info("Teste log");
//		return ResponseEntity.ok(new Retorno(mensagem.concat("1")));
//
//	}
//}
