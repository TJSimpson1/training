package com.fdmgroup.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STREAM")
@NamedQuery(name = "Stream.findByStreamName", query = "SELECT s FROM Stream s WHERE s.name = :givenName")
public class Stream {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stream_gen")
	@SequenceGenerator(name = "stream_gen", sequenceName = "stream_seq", allocationSize=1)
	@Column(name = "STREAM_ID")
	private int id;
	@Column(name="STREAM_NAME", unique=true, nullable=false)
	private String name;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "STREAM_MODULE",
			joinColumns = @JoinColumn(name = "FK_STREAM_ID"),
			inverseJoinColumns = @JoinColumn(name = "FK_MODULE_ID"))
	private List<Module> modules = new ArrayList<>();
	
	
	Stream() {}
	
	
	
	public Stream(String name) {
		super();
		this.name = name;
	}



	public void addModule(Module module) {
		this.modules.add(module);
		module.addStream(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, modules, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stream other = (Stream) obj;
		return id == other.id && Objects.equals(modules, other.modules) && Objects.equals(name, other.name);
	}



	@Override
	public String toString() {
		return "Stream [id=" + id + ", name=" + name + ", modules=" + modules + "]";
	}
	
	
	
	
	
	
}
