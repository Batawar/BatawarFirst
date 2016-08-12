package com.test.me.common;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingbo.lin on 2016/8/3.
 */


@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	}

	public List findAll(){
		String sql = "SELECT * FROM mytest.user";
		List<User> userList = new ArrayList<>();

		userList = this.jdbcTemplate.query(sql,new UserMapper());

		return userList;
	}

	public User findAll(int id){
		String sql = "select * from user where id = ?";
		List<User> list = jdbcTemplate.query(sql,new UserMapper());
		return list.get(0);
	}

	public String getPassword(int id){
		String sql = "select password from user where id = ?";
		return this.jdbcTemplate.queryForObject(sql,String.class,id);
	}

	public String getName(int id ){
		String sql = "select username from user where id = ?";
		return this.jdbcTemplate.queryForObject(sql,String.class,id);
	}

	public void changePassword(int id,String password){
		String sql = "update user set password = ? where id = ?";
		jdbcTemplate.update(sql,password,id);
	}

	public void changeName(int id,String name){
		String sql = "update user set username = ? where id = ?";
		jdbcTemplate.update(sql,name,id);
	}


	public void delete(int id){
		String sql = "DELETE FORM user WHERE id=?";
		jdbcTemplate.update(sql,id);
	}

	public String getId(String name,String password){
		String sql = "select id from user where username = ? and password = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{name,password}, String.class);
	}

//	@Caching(
//			put = {
//					@CachePut(value = "user", key = "#user.id"),
//					@CachePut(value = "user", key = "#user.name"),
//					@CachePut(value = "user", key = "#user.password")
//			}
//	)
	public User insert(String name, String password){
		final String n = name;
		final String p = password;
		final String sql = "INSERT INTO user(username,password) VALUES(?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql,new String[]{"id"});
				ps.setString(1,n);
				ps.setString(2,p);
				return ps;
			}
		},keyHolder);

		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setId(keyHolder.getKey().intValue());
		return user;
	}



/*
	public Collection<User> doQuery(){
		String sql = "SELECT T.id,T.username,T.password FORM USER T";
		return super.getJdbcTemplate().query(sql, new UserMapper());
	}
*/
}
