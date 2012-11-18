
package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.Serializable;

import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import javax.faces.event.ActionEvent;

@SuppressWarnings("serial")
public class menuSuperAdminBean implements Serializable {  
	
	public static String DEFAULT_PAGE = "/menuPrincipalSuperAdmin.xhtml"; 
    private String urlActualNavegacion = DEFAULT_PAGE;
	//"#{menuSuperAdminBean.geturlActual}"
    //<p:remoteCommand name="lazyANew" action="#{menuSuperAdminBean.nuevoAdmin}" update="testOutput" onsuccess="alert('test')"/>
	//<p:remoteCommand name="lazyAList" actio="#{menuSuperAdminBean.eliminarAdmin}" update="testOutput"  onsuccess="alert('test')" />
	//<p:remoteCommand name="lazyASearch" action="#{menuSuperAdminBean.modificarAdmin}" update="testOutput" onsuccess="alert('test')"/>
    // <ui:include src="#{menuSuperAdminBean.urlActualNavegacion}" />
    //<p:outputPanel id="testOutput" autoUpdate="true" > 
	public  menuSuperAdminBean(){
    	
    }
    
    public String getUrlActualNavegacion() {
		return urlActualNavegacion;
	}

	public void setUrlActualNavegacion(String urlActualNavegacion) {
		this.urlActualNavegacion = urlActualNavegacion;
	}
    
    public void nuevoAdmin() {  
    	this.urlActualNavegacion = "/prueba.xhtml"; 
    }  
      
    public void eliminarAdmin() {  
    	this.urlActualNavegacion = DEFAULT_PAGE;  
    }  
      
    public void modificarAdmin() {  
    	this.urlActualNavegacion = "/prueba.xhtml";   
    } 
      
    public String nuevoCliente() {  
    	return "/prueba.xhtml";
    }  
      
    public void eliminarCliente() {  
    	this.urlActualNavegacion = "/prueba.xhtml"; 
    }  
      
    public void modificarCliente() {  
    	this.urlActualNavegacion = DEFAULT_PAGE; 
    }  
    
    
    
    public void nuevoTecnico(ActionEvent actionEvent) {  
        addMessage("Data saved");  
    }  
      
    public void eliminarTecnico(ActionEvent actionEvent) {  
        addMessage("Data updated");  
    }  
      
    public void modificarTecnico(ActionEvent actionEvent) {  
        addMessage("Data deleted");  
    }  
    
    public void nuevoUsuario(ActionEvent actionEvent) {  
        addMessage("Data saved");  
    }  
      
    public void eliminarUsuario(ActionEvent actionEvent) {  
        addMessage("Data updated");  
    }  
      
    public void modificarUsuario(ActionEvent actionEvent) {  
        addMessage("Data deleted");  
    }  
    
    public void nuevaCategoria(ActionEvent actionEvent) {  
        addMessage("Data saved");  
    }  
      
    public void renombrarCategoria(ActionEvent actionEvent) {  
        addMessage("Data updated");  
    }
    
    public void nuevoGrupo(ActionEvent actionEvent) {  
        addMessage("Data saved");  
    }  
      
    public void eliminarGrupo(ActionEvent actionEvent) {  
        addMessage("Data updated");  
    }  
      
    public void modificarGrupo(ActionEvent actionEvent) {  
        addMessage("Data deleted");  
    } 
    
    public void nuevoReporte(ActionEvent actionEvent) {  
        addMessage("Data saved");  
    }  
      
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}  
  