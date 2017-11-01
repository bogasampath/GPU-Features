package com.gpu_features;
//JDO annotated class that will store a GPU and its features

//imports
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

//class definition
@PersistenceCapable
public class GPU_db {
//the identifier for the object as we will be using the user key for this
//we need to use a key object here
@PrimaryKey
@Persistent
private Key gpu_name;
//the timezone offset for this user
@Persistent
private String geometryShader;
@Persistent
private String tesselationShader;
@Persistent
private String shaderInt16;
@Persistent
private String sparseBinding;
@Persistent
private String textureCompressionETC2;
@Persistent
private String vertexPipelineStoresAndAtomics;

//anything below this line is for our convenience and will not be used by
//JDO
//setter and getter for the GPU
public void setGPU(final Key gpu_name) { this.gpu_name = gpu_name; }
public Key gpu_name() { return gpu_name; }

//setter and getter for the features
public void setGeometryShader(final String geometryShader) { this.geometryShader = geometryShader; }
public String getGeometryShader() { return geometryShader; }

//setter and getter for the features
public void setTesselationShader(final String tesselationShader) { this.tesselationShader = tesselationShader; }
public String getTesselationShader() { return tesselationShader; }

public void setShaderInt16(final String shaderInt16) { this.shaderInt16 = shaderInt16; }
public String getShaderInt16() { return shaderInt16; }

public void setSparseBinding(final String sparseBinding) { this.sparseBinding = sparseBinding; }
public String getSparseBinding() { return sparseBinding; }

public void setTextureCompressionETC2(final String textureCompressionETC2) { this.textureCompressionETC2 = textureCompressionETC2; }
public String getTextureCompressionETC2() { return textureCompressionETC2; }

public void setVertexPipelineStoresAndAtomics(final String vertexPipelineStoresAndAtomics) { this.vertexPipelineStoresAndAtomics = vertexPipelineStoresAndAtomics; }
public String getVertexPipelineStoresAndAtomics() { return vertexPipelineStoresAndAtomics; }

}