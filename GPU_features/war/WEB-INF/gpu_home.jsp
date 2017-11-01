<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>GPU Features</title>
	</head>
	<body>
		<h3 style="text-align:center;">GPU and Features</h3>
		<c:choose>
			<c:when test = "${user != null}">
			<p>Welcome ${user.email} <br/>You can signOut <a href="${logout_url}">here</a> <br/></p>
			<!-- Form for GPU -->
			<h4>ADD GPU's with features:</h4>
			<form action="/" method="post">
				GPU Name:  <input type="text" name="gpu_name"/>
				<br/>
				<br/>
				Features:<br/>
				<input type="checkbox" value="ON" name="geometryShader"/> geometryShader<br/>
				<input type="checkbox" value="ON" name="tesselationShader"/> tesselationShader<br/>
				<input type="checkbox" value="ON" name="shaderInt16"/> shaderInt16<br/>
				<input type="checkbox" value="ON" name="sparseBinding"/> sparseBinding<br/>
				<input type="checkbox" value="ON" name="textureCompressionETC2"/>textureCompressionETC2<br/>
				<input type="checkbox" value="ON" name="vertexPipelineStoresAndAtomics"/> vertexPipelineStoresAndAtomics<br/>
				
			<input type="submit" value="Add"><br/>
		</form>
		<br>
		<form action="/" method ="get">
		<h4>Search similar GPU's with same features:</h4>
				Features:<br/>
				<input type="checkbox" value="ON" name="geometryShader1"/> geometryShader<br/>
				<input type="checkbox" value="ON" name="tesselationShader1"/> tesselationShader<br/>
				<input type="checkbox" value="ON" name="shaderInt161"/> shaderInt16<br/>
				<input type="checkbox" value="ON" name="sparseBinding1"/> sparseBinding<br/>
				<input type="checkbox" value="ON" name="textureCompressionETC21"/>textureCompressionETC2<br/>
				<input type="checkbox" value="ON" name="vertexPipelineStoresAndAtomics1"/> vertexPipelineStoresAndAtomics<br/>
				<input type="submit" value ="Search">
		</form>
		
		
		</c:when>
			<c:otherwise>
			<p>Welcome!<a href="${login_url}">Sign in or register</a></p>
			
			</c:otherwise>
		</c:choose>
		
	</body>
</html>