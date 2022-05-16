package br.com.eventosapi.controller;


import br.com.eventosapi.eventosService.EventoServiceimpl;
import br.com.eventosapi.model.Eventos;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@CrossOrigin
public class EventoController {

    @Autowired
    private EventoServiceimpl eventoService;


    @GetMapping("/list")
    public List<Eventos> listaDeEventos(){
        return eventoService.findAllEventos();
    }

    @PostMapping("/addEvento")
    public String addEvento(@RequestBody Eventos eventos,
                            @RequestParam("image")MultipartFile photo) throws IOException {
        try {
//            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//            eventos.setFotoEvento(fileName);
            eventos.setFotoEvento(photo.getBytes());
            eventoService.saveEvento(eventos);

//            String uploadDir = "evento-fotos/" + savedEvento.getId();
//            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);



        }catch (ConstraintViolationException e){
            return "Faltou algum valor";
        }
        return "Evento cadastrado com sucesso";
    }

    @DeleteMapping("/deleteEvento{id}")
    public void deleteEvento(@PathVariable("id") long id){
        Optional<Eventos> eventosOpt = eventoService.findEventoById(id);
        if(eventosOpt.isEmpty()){
            throw new IllegalArgumentException("Pessoa invalida");
        }
        eventoService.deleteEvento(eventosOpt.get());
    }

    @PutMapping("/updateEvento{id}")
    public String updateEvento(@RequestBody Eventos eventos, @PathVariable("id") long id){
        Optional<Eventos> eventosOpt = eventoService.findEventoById(id);
        if(eventosOpt.isEmpty()){
            throw new IllegalArgumentException("Pessoa invalida");
        }
        eventosOpt.get().setNome_evento(eventos.getNome_evento());
        eventosOpt.get().setLocal(eventos.getLocal());
        eventosOpt.get().setPreco(eventos.getPreco());
        eventosOpt.get().setDataEvento(eventos.getDataEvento());
        eventosOpt.get().setFotoEvento(eventos.getFotoEvento());
        eventoService.saveEvento(eventosOpt.get());
        return "Evento editado com sucesso";
    }

}
