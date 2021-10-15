package com.ibm.credit.profile.service;



import com.ibm.credit.profile.exception.DataExcepcion;
import com.ibm.credit.profile.model.Request;
import com.ibm.credit.profile.model.Response;

public interface IProfileService {
	
	Response getCard(String uid, Request request) throws DataExcepcion;

}
