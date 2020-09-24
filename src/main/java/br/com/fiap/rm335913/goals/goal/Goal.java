package br.com.fiap.rm335913.goals.goal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@Entity(name = "goal")
public class Goal implements Serializable {

	private static final long serialVersionUID = 4092382196142442582L;

	@JsonProperty("id")
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("name")
	@Column(name = "name", nullable = false, length = 150)
	@NotNull(message = "Invalid name")
	private String name;

	@JsonProperty("description")
	@Column(name = "description", nullable = false, length = 500)
	@NotNull(message = "Invalid description")
	private String description;

	@JsonProperty("goalValue")
	@Column(name = "goal_value", nullable = false)
	@NotNull(message = "Invalid goal value")
	private double goalValue;

	@JsonProperty("actualValue")
	@Column(name = "actual_value", nullable = false)
	private double actualValue;

	@JsonProperty("createdDate")
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getGoalValue() {
		return goalValue;
	}

	public void setGoalValue(double goalValue) {
		this.goalValue = goalValue;
	}

	public double getActualValue() {
		return actualValue;
	}

	public void setActualValue(double actualValue) {
		this.actualValue = actualValue;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Goal [id=" + id + ", name=" + name + ", description=" + description + ", goalValue=" + goalValue
				+ ", actualValue=" + actualValue + ", createdDate=" + createdDate + "]";
	}

}
