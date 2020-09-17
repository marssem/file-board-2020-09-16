package com.file.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


@WebServlet(value = "/MybatisServlet", loadOnStartup = 1)
public class MybatisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SqlSessionFactory ssf;
	
	static {
		ssf = new SqlSessionFactoryBuilder().build(MybatisServlet.class.getClassLoader().getResourceAsStream("resources/mybatis-config.xml"));
	}
	public static SqlSession getSession() {
    	return  ssf.openSession();
    }
   

}
