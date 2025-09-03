package ar.edu.utn.dds.k3003.controller;

import ar.edu.utn.dds.k3003.facades.FachadaProcesadorPdI;
import ar.edu.utn.dds.k3003.facades.dtos.PdIDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pdis")
public class PdIController {

    private final FachadaProcesadorPdI fachadaProcesadorPdI;

    // Constructor
    @Autowired
    public PdIController(FachadaProcesadorPdI fachadaProcesadorPdI) {
        this.fachadaProcesadorPdI = fachadaProcesadorPdI;
    }

    // GET /pdis?hecho={hechoId}
    // GET /pdis
    @GetMapping
    public ResponseEntity<List<PdIDTO>> listarPdisPorHecho(
            @RequestParam(required = false) String hecho) {
        if (hecho != null) {
            // GET /pdis?hecho={hechoId}
            return ResponseEntity.ok(fachadaProcesadorPdI.buscarPorHecho(hecho));
        } else {
            // GET /pdis
            throw new UnsupportedOperationException("Falta agregar pids a FachadaProcesadorPdI");
            // return ResponseEntity.ok(fachadaProcesadorPdI.pdis());
        }
    }

    // GET /pdis/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PdIDTO> obtenerPdiPorId(@PathVariable Long id) {
        PdIDTO dto = fachadaProcesadorPdI.buscarPdIPorId(String.valueOf(id));
        return ResponseEntity.ok(dto);
    }

    // POST /pdis
    @PostMapping
    public ResponseEntity<PdIDTO> procesarNuevoPdi(@RequestBody PdIDTO pdi) {
        System.out.println("alijnaeoñcuanc{pinaOEcuia>c}");
        System.out.println("Queremos un idHecho: " + pdi.hechoId());
        System.out.println("Queremos un descripcion: " + pdi.descripcion());
        System.out.println("Queremos un lugar: " + pdi.lugar());
        System.out.println("Queremos un momento: " + pdi.momento());
        return ResponseEntity.ok(fachadaProcesadorPdI.procesar(pdi));
    }
}
