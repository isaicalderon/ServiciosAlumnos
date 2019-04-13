package com.matco.manual.servicios;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.matco.manual.facade.AlumnoFacade;
import com.matco.manual.entity.Alumno;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "alumnoServicio")
@Path("alumnoServicio")
public class AlumnoServicios extends Generic{
	
	AlumnoFacade alumnoFacade = new AlumnoFacade(archivoConfiguracionServicio);
	
	@GET
	@Path("guardarAlumno")
	@Produces(MediaType.APPLICATION_JSON)
	public int guardarAlumno(@QueryParam("nombres") String nombres,
			@QueryParam("apePaterno") String apePaterno,
			@QueryParam("apeMaterno") String apeMaterno,
			@QueryParam("creadoPor") String creadoPor) throws Exception {
		Alumno tmp = new Alumno();
		tmp.setNombres(nombres);
		tmp.setApellidoPaterno(apePaterno);
		tmp.setApellidoMaterno(apeMaterno);
		tmp.setCreadoPor(creadoPor);
		return alumnoFacade.guardarAlumno(tmp);
	}
	
	@PUT
	@Path("modificarAlumno")
	public void modificarAlumno(
			@QueryParam("matricula") int matricula,
			@QueryParam("nombres") String nombres,
			@QueryParam("apePaterno") String apePaterno,
			@QueryParam("apeMaterno") String apeMaterno,
			@QueryParam("modificadoPor") String modificadoPor) throws Exception {
		
		Alumno tmp = new Alumno();
		tmp.setMatricula(matricula);
		tmp.setNombres(nombres);
		tmp.setApellidoPaterno(apePaterno);
		tmp.setApellidoMaterno(apeMaterno);
		tmp.setModificadoPor(modificadoPor);
		alumnoFacade.modificarAlumno(tmp);
	}
	
	@DELETE
	@Path("eliminarAlumno")
	public void eliminarAlumno(@QueryParam("matricula") int matricula) throws Exception {
		Alumno tmp = new Alumno();
		tmp.setMatricula(matricula);
		alumnoFacade.eliminarAlumno(tmp);
	}
	
	@GET
	@Path("obtenerTodosAlumnos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alumno> obtenerTodosAlumnos() throws Exception {
		List<Alumno> res = alumnoFacade.obtenerTodosAlumnos();
		return res;
	}
}
