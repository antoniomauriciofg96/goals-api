package br.com.fiap.rm335913.goals.goal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.rm335913.goals.response.ResponseApi;
import br.com.fiap.rm335913.goals.response.ResponseApiError;

@Service("goalService")
public class GoalService {

	private GoalRepository repository;

	@Autowired
	public GoalService(GoalRepository repository) {
		this.repository = repository;
	}

	public ResponseApi findAll() throws ResponseApiError {
		try {
			List<Goal> goals = repository.findAll();
			return new ResponseApi(goals);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseApiError("Error fetching goals", 500);
		}
	}

	public ResponseApi save(Goal goal) throws ResponseApiError {
		System.out.println(goal);
		try {
			goal = repository.saveAndFlush(goal);
			return new ResponseApi(goal);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseApiError("Error saving goal", 500);
		}
	}

	public ResponseApi update(Goal goal) throws ResponseApiError {
		try {
			goal = repository.saveAndFlush(goal);
			return new ResponseApi(goal);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseApiError("Error updating goal", 500);
		}
	}

	public ResponseApi delete(Long id) throws ResponseApiError {
		try {
			repository.deleteById(id);
			return new ResponseApi("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseApiError("Error deleting goal", 500);
		}
	}

	public ResponseApi credit(GoalCredDebDTO credit) throws ResponseApiError {

		try {

			Optional<Goal> goalOpt = repository.findById(credit.getId());

			Goal goal = goalOpt.get();

			goal.setActualValue(goal.getActualValue() + credit.getValue());

			goal = repository.saveAndFlush(goal);

			return new ResponseApi("Updated");

		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseApiError("Error updating goal", 500);
		}
	}
	
	public ResponseApi debit(GoalCredDebDTO debit) throws ResponseApiError {

		try {

			Optional<Goal> goalOpt = repository.findById(debit.getId());

			Goal goal = goalOpt.get();

			goal.setActualValue(goal.getActualValue() - debit.getValue());

			goal = repository.saveAndFlush(goal);

			return new ResponseApi("Updated");

		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseApiError("Error updating goal", 500);
		}
	}
}
