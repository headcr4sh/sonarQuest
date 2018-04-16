package com.viadee.sonarQuest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Artefact")
public class Artefact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    private String icon;

    @Column(name = "price")
    private Long price;
    
    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name="level_id")
    private Level minLevel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Artefact_Skill", joinColumns = @JoinColumn(name = "artefact_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"))
    private List<Skill> skills;

    @ManyToMany(mappedBy = "artefacts", cascade = CascadeType.ALL)
    private List<Developer> developers;

    public Artefact() {
    }

    public Artefact(String name, String icon, Long price, Level minLevel, List<Skill> skills) {
        this.name = name;
        this.icon = icon;
        this.price = price;
        this.minLevel = minLevel;
        this.skills = skills;
    }

    public Artefact(String name, Long price, Long quantity, String description) {
        this.name 		 = name;
        this.price 		 = price;
        this.quantity 	 = quantity;
        this.description = description;
    }

    public Artefact(String name, String icon, Long price, Long quantity, String description) {
        this.name 		 = name;
        this.icon 		 = icon;
        this.price 		 = price;
        this.quantity 	 = quantity;
        this.description = description;
    }

    public Artefact(String name, String icon, Long price, Level minLevel, List<Skill> skills, List<Developer> developers) {
        this.name = name;
        this.icon = icon;
        this.price = price;
        this.minLevel = minLevel;
        this.skills = skills;
        this.developers = developers;
    }
    

	public Artefact(Long id, String name, String icon, Long price, Long quantity, String description, Level minLevel,
			List<Skill> skills, List<Developer> developers) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.minLevel = minLevel;
		this.skills = skills;
		this.developers = developers;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @JsonIgnore
    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Level getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Level minLevel) {
        this.minLevel = minLevel;
    }

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Artefact.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Artefact other = (Artefact) obj;
	    if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
	        return false;
	    }
	    if (this.id != other.id) {
	        return false;
	    }
	    return true;
	}


    
}
