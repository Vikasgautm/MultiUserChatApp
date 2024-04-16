package com.Rd.Chatapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Rd.Chatapp.dto.UserDTO;
import com.Rd.Chatapp.utils.Encryption;
// user crud
public class UserDAO {
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException,Exception{
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="select userid from users where userid=? and password=?";
		try {
			con =CommonDAO.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());
			String encryptedPwd=Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedPwd);
			rs=pstmt.executeQuery();
			return rs.next();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	//public int add(String userid,String password,byte age,String city,String phone,String email,String country,String state,String areCode,String stdCode){
		public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException,Exception {
			System.out.println("Received "+userDTO.getUserid()+" "+userDTO.getPassword());
			Connection connection=null;
			Statement stmt=null;
			try {
			connection =CommonDAO.createConnection();
			// we do a query
			stmt=connection.createStatement();
			int record=stmt.executeUpdate("insert  into users (userid, password)values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')");
			return record;
			}
			
			finally {
				if(stmt!=null) {
				stmt.close();
				}
				if(connection!=null) {
				connection.close();
				}
			
			}
			
	}
}
