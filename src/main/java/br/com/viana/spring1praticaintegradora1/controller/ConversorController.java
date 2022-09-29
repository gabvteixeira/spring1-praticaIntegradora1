package br.com.viana.spring1praticaintegradora1.controller;

import br.com.viana.spring1praticaintegradora1.service.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversor/")
public class ConversorController {

    @Autowired
    private ConversorService conversorService;

    @GetMapping("/decimal/{valor}")
    public String converterDecimalToRomano(@PathVariable int valor){
        return "O valor de " + valor + " em numeral romano é: " +
                this.conversorService.converterDecimalToRomano(valor);
    }

    @GetMapping("/romano/{valor}")
    public String converterRomanoToDecimal(@PathVariable String valor){
        return "O valor de " + valor + " em decimal é: "
                + this.conversorService.converterRomanoToDecimal(valor);
    }
}
