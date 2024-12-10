package com.app.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.app.resource.EmployeeResource;
// In Rest there is not dispatcher server so we created this class
@Component
public class RestConfig extends ResourceConfig{

	public RestConfig() {
		
		register(EmployeeResource.class);
	}

	
	

}
