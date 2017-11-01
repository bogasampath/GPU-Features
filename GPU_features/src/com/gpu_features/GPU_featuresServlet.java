package com.gpu_features;

import java.util.*;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

//import com.google.appengine.api.datastore.DatastoreService;
//import com.google.appengine.api.datastore.DatastoreServiceFactory;
//import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.*;

import javax.jdo.Query;


@SuppressWarnings("serial")
public class GPU_featuresServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		resp.setContentType("text/html");
		//get the GPU_name and features from the form
		String geometryShader1 = null;
		String tesselationShader1 = null ;
		String shaderInt161 = null;
		String sparseBinding1 = null;
		String textureCompressionETC21 = null;
		String vertexPipelineStoresAndAtomics1 = null;
		
		try{
			geometryShader1 = req.getParameter("geometryShader1");
			tesselationShader1 = req.getParameter("tesselationShader1");
			shaderInt161 = req.getParameter("shaderInt161");
			sparseBinding1 = req.getParameter("sparseBinding1");
			textureCompressionETC21 = req.getParameter("textureCompressionETC21");
			vertexPipelineStoresAndAtomics1 = req.getParameter("vertexPipelineStoresAndAtomics1");
			
		}catch(Exception e){
			// if failed to update redirect to /
			resp.sendRedirect("/");
		}
		
		PersistenceManager pm = null;
		pm = PMF.get().getPersistenceManager();
		
		
		String filter = "this.geometryShader == :geometryShader1 && this.tesselationShader == :tesselationShader1 && this.shaderInt16 == :shaderInt161 && this.sparseBinding == :sparseBinding1 && this.textureCompressionETC2 == :textureCompressionETC21 && this.vertexPipelineStoresAndAtomics == :vertexPipelineStoresAndAtomics1";
		Query q = pm.newQuery(GPU_db.class,filter);
		Map params = new HashMap();
		
		params.put("geometryShader1", geometryShader1);
		params.put("tesselationShader1", tesselationShader1);
		params.put("shaderInt161", shaderInt161);
		params.put("sparseBinding1", sparseBinding1);
		params.put("textureCompressionETC21", textureCompressionETC21);
		params.put("vertexPipelineStoresAndAtomics1", vertexPipelineStoresAndAtomics1);
		q.compile();
		List<GPU_db> result = (List<GPU_db>)  q.executeWithMap(params);
		pm.close();
		
		for(GPU_db p : result){
			resp.getWriter().println("GPU's: ");
			resp.getWriter().println(p.gpu_name());
			System.out.println(p.gpu_name());
		}
		UserService us = UserServiceFactory.getUserService();
		User u = us.getCurrentUser();
		
		String login_url = us.createLoginURL("/");
		String logout_url = us.createLogoutURL("/");
		
		req.setAttribute("user", u);
		req.setAttribute("login_url", login_url);
		req.setAttribute("logout_url", logout_url);
		// get a request dispatcher and forward onto the JSP
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/gpu_home.jsp");
		rd.forward(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		//get the GPU_name and features from the form
		String gpu_name="";
		String geometryShader = null;
		String tesselationShader = null;
		String shaderInt16 = null;
		String sparseBinding = null;
		String textureCompressionETC2 = null;
		String vertexPipelineStoresAndAtomics = null;
		
		try{
			gpu_name = req.getParameter("gpu_name");
			geometryShader = req.getParameter("geometryShader");
			tesselationShader = req.getParameter("tesselationShader");
			shaderInt16 = req.getParameter("shaderInt16");
			sparseBinding = req.getParameter("sparseBinding");
			textureCompressionETC2 = req.getParameter("textureCompressionETC2");
			vertexPipelineStoresAndAtomics = req.getParameter("vertexPipelineStoresAndAtomics");
			
		}catch(Exception e){
			// if failed to update redirect to /
			resp.sendRedirect("/");
		}
		
	
		// get access to the user service to get our user
		UserService us = UserServiceFactory.getUserService();
		User u = us.getCurrentUser();
		
		
		PersistenceManager pm = null;
		GPU_db settings;
		Key GPU_key = KeyFactory.createKey("GPU_db", gpu_name);
		pm = PMF.get().getPersistenceManager();
		try {
		
		settings = pm.getObjectById(GPU_db.class, GPU_key);
		
		} catch (Exception e) {
		// will only fail if the datastore goes down as this is
		// already in the datastore
			settings=new GPU_db();
			settings.setGPU(GPU_key);
			settings.setGeometryShader(geometryShader);
			settings.setTesselationShader(tesselationShader);
			settings.setShaderInt16(shaderInt16);
			settings.setSparseBinding(sparseBinding);
			settings.setTextureCompressionETC2(textureCompressionETC2);
			settings.setVertexPipelineStoresAndAtomics(vertexPipelineStoresAndAtomics);
			pm.makePersistent(settings);
		}
		System.out.println(gpu_name);
		System.out.println(geometryShader);
		System.out.println(tesselationShader);
		System.out.println(shaderInt16);
		System.out.println(sparseBinding);
		System.out.println(textureCompressionETC2);
		System.out.println(vertexPipelineStoresAndAtomics);
		
		pm.close();
		// will only fail if the datastore goes down as this is already in the datastore
		resp.sendRedirect("/");
	}
}

