package br.com.fiap.rm335913.goals.goal;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class GoalCredDebDTO implements Serializable {

	private static final long serialVersionUID = 6937961946303409448L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("value")
	@NotNull(message = "Invalid new value")
	private double value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GoalCreditDTO [id=" + id + ", value=" + value + "]";
	}

}
