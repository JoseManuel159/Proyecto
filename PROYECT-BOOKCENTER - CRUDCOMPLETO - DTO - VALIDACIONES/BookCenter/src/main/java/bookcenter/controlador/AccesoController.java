package bookcenter.controlador;

import bookcenter.dtos.AccesoDTO;
import bookcenter.mappers.AccesoMapper;
import bookcenter.servicio.AccesoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accesos")
@RequiredArgsConstructor
public class AccesoController {
    private final AccesoService accesoService;
    private final AccesoMapper accesoMapper;
    @PostMapping("/user")
    public ResponseEntity<List<AccesoDTO>> getMenusByUser(@RequestBody String username){
        List<AccesoDTO> accesosDTO = accesoMapper.toDTOs(accesoService.getAccesoByUser(username));
        return ResponseEntity.ok(accesosDTO);
    }
}
