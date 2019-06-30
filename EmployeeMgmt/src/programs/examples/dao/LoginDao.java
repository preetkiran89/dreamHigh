package programs.examples.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.programs.database.Database;

import programs.examples.model.LoginModel;
import programs.examples.model.PasswordChangeModel;
import programs.examples.utils.EmployeeHelper;
import programs.examples.utils.EmployeeStatusConstants;

@Repository
public class LoginDao 
{
   
   private static final Logger LOGGER = LoggerFactory.getLogger(LoginDao.class);
   
   @Autowired
   private Environment env;
   
   void updatePasswords(Environment env){
	   String updateLoginQuery = "select * from employee_login ;";
		try (Connection conn = Database.getConnection(env);
				Statement pstmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                   ResultSet.CONCUR_UPDATABLE);) {
			ResultSet rs = pstmt.executeQuery(updateLoginQuery);
         	if (conn != null) {
				while(rs.next()){
					String password = rs.getString(3);
					rs.updateString(3, EmployeeHelper.getHashFromPassword(password));
					rs.updateRow();
				}
			}
		} catch (SQLException | NoSuchAlgorithmException e) {
			LOGGER.error("Error while updting login info for with error [{}]",e);
		}
   }
   
   public LoginModel validateUser(LoginModel loginModel){
	   String loginQuery = "select password_hash,last_login_date,first_time_login,email from employee_login where loginid = ?;";
	   LoginModel loginModelDB = new LoginModel();
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(loginQuery);) {
			
			pstmt.setInt(1, loginModel.getUserid());
			ResultSet rs = pstmt.executeQuery();						
			if (conn != null) {
				if (rs.next()){
					loginModelDB.setPassword_hash(rs.getString(1));
					if(!EmployeeHelper.isEmpty(rs.getString("last_login_date")))              // check for first time user 
				     loginModelDB.setLast_login_date(rs.getTimestamp(2).getTime());
				    loginModelDB.setFirst_login(rs.getInt(3));
				    loginModelDB.setEmail(rs.getString(4));
				}    
			}
		} catch (SQLException e) {
			LOGGER.error("Error while validating user [{}] with error [{}]", loginModel.toString(), e);
		}
	   return loginModelDB;
   }
   
   public void updateLoginInfo(LoginModel loginModel){
		String updateLoginQuery = "update employee_login set last_login_date = ? where loginid = ? ;";
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(updateLoginQuery);) {
            int x = 0;
			if (conn != null) {
				pstmt.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setInt(2, loginModel.getUserid());
				x = pstmt.executeUpdate();
			}
			if(x == 0)
			  LOGGER.error("Couldnt update login info for user [{}] with error [{}]", loginModel.toString());
		} catch (SQLException e) {
			LOGGER.error("Error while updting login info for user [{}] with error [{}]", loginModel.toString(), e);
		}
   }
   
   public String changePassword(PasswordChangeModel passwordChangeModel){
		String changePasswordQuery = "update employee_login set password_hash = ?,first_time_login = 0 where loginid = ? ;";
		String passwordChangeStatus = EmployeeStatusConstants.PASSWORD_CHANGE_ERROR;
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(changePasswordQuery);) {
			int x = 0;
			if (conn != null) {
				LOGGER.info("Query for changing password : [{}] ",changePasswordQuery);
				pstmt.setString(1, EmployeeHelper.getHashFromPassword(passwordChangeModel.getNewPassword()));
				pstmt.setInt(2, passwordChangeModel.getUserid());
				x = pstmt.executeUpdate();
			}
			if (x == 0)
				LOGGER.error("Couldnt update password for user [{}]",
						passwordChangeModel.getUserid());
			else
				passwordChangeStatus = EmployeeStatusConstants.PASSWORD_CHANGED;
		} catch (SQLException | NoSuchAlgorithmException e) {
			LOGGER.error("Error while updating password info for user [{}] with error [{}]",
					passwordChangeModel.getUserid(), e);
		}
		return passwordChangeStatus;
   }
}
