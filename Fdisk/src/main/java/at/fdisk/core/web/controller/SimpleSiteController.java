package at.fdisk.core.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/simple")
public class SimpleSiteController {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleSiteController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getCurrentMenu() {
		LOG.debug("Fdisk Simple via ResponseEntity");
		return new ResponseEntity<String>("Fdisk", HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/directly")
	@ResponseBody
	public String noodleWorld() {
		LOG.debug("Fdisk Simple directly to ResponseBody");
		return "Fdisk Management";
	}

}