package programs.examples.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class LeaveDao 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveDao.class);

	@Autowired
	private Environment env;
	
	public void applyLeave(){
		
	}
}
