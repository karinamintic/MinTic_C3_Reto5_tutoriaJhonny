package com.retos.mireto4.Web;

import java.util.List;
import java.util.Optional;

import com.retos.mireto4.Modelo.Cliente;
import com.retos.mireto4.Servicios.ClienteServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClienteWeb
{
    @Autowired
    private ClienteServicios servicios;
    @GetMapping("/all")
    public List <Cliente> getCliente(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") int clientid) {
        return servicios.getCliente(clientid);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        return servicios.save(cliente);
    }
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente) {
        return servicios.update(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clienteId) {
        return servicios.deleteClient(clienteId);
    }
}