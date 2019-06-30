package programs.examples.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.programs.database.Database;

import programs.examples.model.LoginModel;
import programs.examples.utils.EmployeeHelper;
import programs.examples.utils.EmployeeStatusConstants;

@Repository
public class RegisterDao 
{
	@Autowired
	private Environment env;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterDao.class);

	public boolean registerEmployeeByAdmin(LoginModel loginModel) {
		boolean registered = false;
		String addEmployeeQuery = "insert into employee_login (loginid,password_hash,user_created_date,"
				+ "email) values (?,?,?,?);";
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(addEmployeeQuery);) {

			if (conn != null) {
				pstmt.setInt(1, loginModel.getUserid());
				pstmt.setString(2, EmployeeHelper.getHashFromPassword(loginModel.getPassword_hash()));
				pstmt.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(4, loginModel.getEmail());
				int rows = pstmt.executeUpdate();
				if (rows > 0)
					registered = true;
			}
		} catch (SQLException | NoSuchAlgorithmException e) {
			LOGGER.error("Error while adding user [{}] with error [{}]", loginModel.toString(), e);

		}
		return registered;
	}
	
	
	public void registerEmployeeInfo(LoginModel loginModel){
		String addEmployeeQuery = "insert into employee_info (empid,email,date_of_joining,profile_status) values (?,?,?,?);";
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(addEmployeeQuery);) {

			if (conn != null) {
				pstmt.setInt(1, loginModel.getUserid());
				pstmt.setString(2, loginModel.getEmail());
				pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
				pstmt.setString(4, EmployeeStatusConstants.PROFILE_STARTED);
				int rows = pstmt.executeUpdate();
				if (rows > 0)
					LOGGER.info("Employee registered : [{}]", loginModel.toString());
			}
		} catch (SQLException e) {
			LOGGER.error("Error while adding user [{}] with error [{}]", loginModel.toString(), e);

		}
	}
}
