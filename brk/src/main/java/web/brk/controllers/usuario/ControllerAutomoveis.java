package web.brk.controllers.usuario;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.brk.dtos.AutomoveisDto;
import web.brk.models.AutomoveisModel;
import web.brk.services.AutomoveisService;

@Controller
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/automoveis")
public class ControllerAutomoveis {

    final AutomoveisService automoveisService;

    public ControllerAutomoveis(AutomoveisService automoveisService) {
        this.automoveisService = automoveisService;
    }

    //Salvar e validar cadastros dos automóveis.
    @PostMapping
    public ResponseEntity<Object> saveAutomoveis(@RequestBody @Valid AutomoveisDto automoveisDto){
        
        if(automoveisService.existsByPlacaCarro(automoveisDto.getPlacaCarro())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Placa já existe.");
        }

        var AutomoveisModel = new AutomoveisModel();
        BeanUtils.copyProperties(automoveisDto, AutomoveisModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(automoveisService.save(AutomoveisModel));
    }

    //Receber lista de automóveis cadastrados.
    @GetMapping
    public ResponseEntity<List<AutomoveisModel>> getAllAutomoveis(){
        return ResponseEntity.status(HttpStatus.OK).body(automoveisService.findAll());
    }

}
