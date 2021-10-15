package com.ibm.credit.profile.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.credit.profile.exception.DataExcepcion;
import com.ibm.credit.profile.mapping.Mapping;
import com.ibm.credit.profile.model.ErrorDetalle;
import com.ibm.credit.profile.model.Request;
import com.ibm.credit.profile.model.Response;
import com.ibm.credit.profile.service.IProfileService;
import com.ibm.credit.profile.util.GUIDGenerator;
import com.ibm.credit.profile.util.LogHandler;
import com.ibm.credit.profile.util.MessageExceptionHandler;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author amoralesm
 *
 */
@RestController
public class ProfileController {
	
	@Autowired
	private IProfileService profileService;
		
	/**
	 * Metodo para validar el perfil de un cliente y ofrecerle tarjetas de credito
	 * @param request
	 * @return
	 * @throws DataExcepcion
	 */
	@PostMapping(Mapping.GETCARDS)
	@ApiOperation(value = "Solicitar tarjeta de crédito", notes = "Solicitar tarjeta de crédito")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud Exitosa", response = Response.class),
			@ApiResponse(code = 400, message = MessageExceptionHandler.MESSAGE_ERROR_VALID, response = ErrorDetalle.class),
			@ApiResponse(code = 406, message = MessageExceptionHandler.MESSAGE_ERROR_BUSINESS, response = ErrorDetalle.class) })
    public ResponseEntity<Response> getCard(@Valid @RequestBody Request request) throws DataExcepcion {
    	String uid=GUIDGenerator.generateGUID();
    	LogHandler.info(uid, getClass(),request.toString());
    	return new ResponseEntity<>(
    			profileService.getCard(uid, request),
    			HttpStatus.OK);
    }
}
