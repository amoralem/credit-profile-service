package com.ibm.credit.profile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.credit.profile.entity.Profile;
import com.ibm.credit.profile.exception.DataExcepcion;
import com.ibm.credit.profile.model.Request;
import com.ibm.credit.profile.model.Response;
import com.ibm.credit.profile.repository.ProfileRepository;
import com.ibm.credit.profile.util.MessageExceptionHandler;
/**
 * Capa de negocio
 * @author amoralesm
 *
 */
@Service
public class ProfileServiceImpl implements IProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Response getCard(String uid, Request request) throws DataExcepcion {
		
		Optional<Profile> optProfile = profileRepository.findProfile(request.getYourPassion(), 
																		request.getMonthlySalary(), 
																		request.getAge());
		if(!optProfile.isPresent()) {			
			optProfile = profileRepository.
					findProfileMonthlyMore(
							request.getYourPassion(),request.getMonthlySalary(),request.getAge());
			
			if(!optProfile.isPresent())
				throw new DataExcepcion(MessageExceptionHandler.DETAIL_REJECTED_REQUEST);
		}
		
		return new Response(optProfile.get().getCreditCards());
	}

	

}
