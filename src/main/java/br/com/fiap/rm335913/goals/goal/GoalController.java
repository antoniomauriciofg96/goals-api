package br.com.fiap.rm335913.goals.goal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.rm335913.goals.constants.ErrorConstantes;
import br.com.fiap.rm335913.goals.response.ResponseApi;
import br.com.fiap.rm335913.goals.response.ResponseApiError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "goal")
@Controller("goalController")
@RestController
@RequestMapping("/goal")
public class GoalController {

    private final GoalService service;

    @Autowired
    public GoalController(GoalService service) {
        this.service = service;
    }

    @ApiOperation(httpMethod = "GET", value = "Get all goals")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErrorConstantes.CODIGO_200_DESCRICAO, response = ResponseApi.class),
            @ApiResponse(code = 401, message = ErrorConstantes.CODIGO_401_DESCRICAO, response = ResponseApiError.class),
            @ApiResponse(code = 500, message = ErrorConstantes.CODIGO_500_DESCRICAO, response = ResponseApiError.class)})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseApi findAll() throws ResponseApiError {
        return service.findAll();
    }

    @ApiOperation(httpMethod = "POST", value = "Create new goal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErrorConstantes.CODIGO_200_DESCRICAO, response = ResponseApi.class),
            @ApiResponse(code = 401, message = ErrorConstantes.CODIGO_401_DESCRICAO, response = ResponseApiError.class),
            @ApiResponse(code = 500, message = ErrorConstantes.CODIGO_500_DESCRICAO, response = ResponseApiError.class)})
    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseApi save(@RequestBody @Valid Goal goal) throws ResponseApiError {
        return service.save(goal);
    }
    
    @ApiOperation(httpMethod = "POST", value = "Credit new value")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErrorConstantes.CODIGO_200_DESCRICAO, response = ResponseApi.class),
            @ApiResponse(code = 401, message = ErrorConstantes.CODIGO_401_DESCRICAO, response = ResponseApiError.class),
            @ApiResponse(code = 500, message = ErrorConstantes.CODIGO_500_DESCRICAO, response = ResponseApiError.class)})
    @ResponseBody
    @PostMapping(value="/credit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseApi credit(@RequestBody @Valid GoalCredDebDTO credit) throws ResponseApiError {
        return service.credit(credit);
    }
    
    @ApiOperation(httpMethod = "POST", value = "Debit new value")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErrorConstantes.CODIGO_200_DESCRICAO, response = ResponseApi.class),
            @ApiResponse(code = 401, message = ErrorConstantes.CODIGO_401_DESCRICAO, response = ResponseApiError.class),
            @ApiResponse(code = 500, message = ErrorConstantes.CODIGO_500_DESCRICAO, response = ResponseApiError.class)})
    @ResponseBody
    @PostMapping(value="/debit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseApi debit(@RequestBody @Valid GoalCredDebDTO debit) throws ResponseApiError {
        return service.debit(debit);
    }

    @ApiOperation(httpMethod = "PUT", value = "Update goal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErrorConstantes.CODIGO_200_DESCRICAO, response = ResponseApi.class),
            @ApiResponse(code = 401, message = ErrorConstantes.CODIGO_401_DESCRICAO, response = ResponseApiError.class),
            @ApiResponse(code = 500, message = ErrorConstantes.CODIGO_500_DESCRICAO, response = ResponseApiError.class)})
    @ResponseBody
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseApi update(@RequestBody @Valid Goal goal) throws ResponseApiError {
        return service.update(goal);
    }

    @ApiOperation(httpMethod = "DELETE", value = "Delete goal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErrorConstantes.CODIGO_200_DESCRICAO, response = ResponseApi.class),
            @ApiResponse(code = 401, message = ErrorConstantes.CODIGO_401_DESCRICAO, response = ResponseApiError.class),
            @ApiResponse(code = 500, message = ErrorConstantes.CODIGO_500_DESCRICAO, response = ResponseApiError.class)})
    @ResponseBody
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseApi delete(@PathVariable("id") Long id) throws ResponseApiError {
        return service.delete(id);
    }


}
