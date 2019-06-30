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

import programs.examples.model.Address;
import programs.examples.model.EmployeeInfo;
import programs.examples.utils.EmployeeStatusConstants;

@Repository
public class ProfileDao {
	@Autowired
	private Environment env;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileDao.class);

	public EmployeeInfo getEmployeeInfoWithoutAddress(int empid) {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		String getEmployeeInfoQuery = "select * from employee_info where empid = ?;";
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(getEmployeeInfoQuery);) {
			pstmt.setInt(1, empid);

			ResultSet resultSet = pstmt.executeQuery();
			if (conn != null) {
				while (resultSet.next()) {
					employeeInfo.setUserId(resultSet.getInt("empid"));
					employeeInfo.setEmail(resultSet.getString("email"));
					employeeInfo.setDate_of_joinig(resultSet.getDate("date_of_joining"));
					employeeInfo.setProfileStatus(resultSet.getString("fname"));
					employeeInfo.setFname(resultSet.getString("fname") == null ? "" : resultSet.getString("fname"));
					employeeInfo.setLname(resultSet.getString("lname") == null ? "" : resultSet.getString("lname"));
					employeeInfo.setMobile(resultSet.getString("mobile_official") == null ? ""
							: resultSet.getString("mobile_official"));
					employeeInfo.setEmail_official(
							resultSet.getString("email_official") == null ? "" : resultSet.getString("email_official"));
				}

			}
		} catch (SQLException e) {
			LOGGER.error("Error while fetching EmployeeInfo [{}] with error [{}]", empid, e);

		}
		return employeeInfo;
	}

	public Address getEmployeeAddress(int empid) {
		Address address = new Address();
		String getAddressQuery = "select * from employee_address where empid = ?;";
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(getAddressQuery);) {
			pstmt.setInt(1, empid);

			ResultSet resultSet = pstmt.executeQuery();
			if (conn != null) {
				while (resultSet.next()) {
					address.setStreet(resultSet.getString("street"));
					address.setCity(resultSet.getString("city"));
					address.setZip(resultSet.getString("zip"));
					address.setCounty(resultSet.getString("county"));
					address.setState(resultSet.getString("state"));
					address.setAddressType(resultSet.getString("address_type"));
					address.setEmpid(empid);
				}

			}
		} catch (SQLException e) {
			LOGGER.error("Error while fetching Address [{}] with error [{}]", empid, e);

		}
		return address;
	}

	public String editEmployeeInfo(EmployeeInfo employeeInfo) {
		String message = EmployeeStatusConstants.PROFILE_UPDATE_ERROR;
		String editProfileQuery = "update employee_info set fname = ?, lname = ?, gender = ? where empid = ?;";
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(editProfileQuery);) {

			if (conn != null) {
				pstmt.setString(1, employeeInfo.getFname());
				pstmt.setString(2, employeeInfo.getLname());
				pstmt.setString(3, "" + employeeInfo.getGender());
				pstmt.setInt(4, employeeInfo.getUserId());
				int k = pstmt.executeUpdate();
				if (k != 1)
					message = EmployeeStatusConstants.PROFILE_UPDATED;
			}
		} catch (SQLException e) {
			LOGGER.error("Error while Saving Employee Info [{}] with error [{}]", employeeInfo.getUserId(), e);

		}
		return message;
	}
}
