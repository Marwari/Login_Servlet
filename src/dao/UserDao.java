package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import config.MyConnection;

public class UserDao {
	Connection con=MyConnection.getConnection();
	public String addUser(User u)
	{
		try {
			PreparedStatement ps=
					con.prepareStatement("insert into newuser values(?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.executeUpdate();
			return "User Added";
	} catch(SQLException e){
		e.printStackTrace();
		return "User Not Added "+e;
	}

	}
	
	public boolean changeUser(User c)
			{
				boolean ret=false;
				try {
					if(validateUser(c.getUsername(), c.getPassword()))
					{
					PreparedStatement ps=
							con.prepareStatement("update newuser set password=? where username=? and password=?");
					ps.setString(2, c.getUsername());
					ps.setString(3, c.getPassword());
					ps.setString(1, c.getNewpassword());
					ps.executeUpdate();
					ret = true;
					}
				
			} catch(SQLException e){
				e.printStackTrace();
				return ret;
			}
				return ret;
			}


	public boolean validateUser(String username, String password)
	{
		try {
			PreparedStatement ps=
					con.prepareStatement("select * from newuser where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}



