package programs.examples.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import programs.examples.dao.RegisterDao;
import programs.examples.model.LoginModel;

@Service
public class RegisterService 
{	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);
    
	@Autowired
    private RegisterDao registerDao;
    
    public boolean registerEmployeeByAdmin(LoginModel loginModel){
    	LOGGER.info("Saving Employee login info ",loginModel.toString());    	
    	boolean registered = registerDao.registerEmployeeByAdmin(loginModel);
    	if(registered)
    		registerDao.registerEmployeeInfo(loginModel);
    	
    	return registered;
    }
    
    void registerEmployee(){
    	
    }
}
