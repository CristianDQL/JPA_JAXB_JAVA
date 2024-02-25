package modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, apellidos, direccion;
	
	//Curso
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="estudiante_curso",
			   joinColumns= {@JoinColumn(name="fk_id_estudiante", referencedColumnName="id") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_curso", referencedColumnName="id")}) 
	private List<Curso> curso;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_perfilEstudiante", referencedColumnName = "id")
	private PerfilEstudiante perfilEstudiante;

	public Estudiante(Integer id, String nombre, String apellidos, String direccion, PerfilEstudiante perfilEstudiante) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.perfilEstudiante = perfilEstudiante;
	}

	public Estudiante() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

	public PerfilEstudiante getPerfilEstudiante() {
		return perfilEstudiante;
	}

	public void setPerfilEstudiante(PerfilEstudiante perfilEstudiante) {
		this.perfilEstudiante = perfilEstudiante;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", curso=" + curso + ", perfilEstudiante=" + perfilEstudiante + "]";
	}

	
	
	

}
