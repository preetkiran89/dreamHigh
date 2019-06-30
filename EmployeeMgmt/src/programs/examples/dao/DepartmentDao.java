package programs.examples.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.programs.database.Database;

import programs.examples.model.LoginModel;
import programs.examples.utils.EmployeeHelper;

@Repository
public class DepartmentDao 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

	@Autowired
	private Environment env;
	
	public void getManagerInfo(int empid){
			   String getMangerInfoQuery = "select emp;";
			   try (Connection conn = Database.getConnection(env);
						PreparedStatement pstmt = conn.prepareStatement(getMangerInfoQuery);) {
					
					pstmt.setInt(1, empid);
					ResultSet rs = pstmt.executeQuery();						
					if (conn != null) {
						if (rs.next()){
							
						}    
					}
				} catch (SQLException e) {
					LOGGER.error("Error while validating user [{}] with error [{}]", empid, e);
				}
		   
	}
}
