package programs.examples.service;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import programs.examples.dao.LoginDao;
import programs.examples.model.LoginModel;
import programs.examples.model.PasswordChangeModel;
import programs.examples.utils.EmployeeHelper;

@Service
public class AuthenticationService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	private LoginDao loginDao;
	    
	private boolean firstTimeLogin = false;
	
	public String authenticateUser(LoginModel loginModel) {
		String login = "Not Authenticated";
		try {
			LoginModel loginModelDB = loginDao.validateUser(loginModel);
			firstTimeLogin = loginModelDB.getFirst_login() == 1 ? true : false;
			
			if (!EmployeeHelper.isEmpty(loginModelDB.getPassword_hash())
					&& loginModelDB.getPassword_hash().equals(EmployeeHelper.getHashFromPassword(loginModel.getPassword_hash()))) {
				if (firstTimeLogin) {
					LOGGER.info("User Authenticated : First time user [{}] ", loginModel.toString());
					login = "Authenticated First time Login";
				} else {
					LOGGER.info("User Authenticated [{}] ", loginModel.toString());
					login = "Authenticated";
					LOGGER.info(" Updating login info [{}] ", loginModel.toString());
					loginDao.updateLoginInfo(loginModel);
				}

			} else
				LOGGER.error("User/Password dosent match [{}] ", loginModel.toString());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	public String changePasswordFirstTimeUser(PasswordChangeModel passwordChangeModel){	
		return loginDao.changePassword(passwordChangeModel);
	}
    
}

