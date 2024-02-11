package api.alianza.controller;


import api.alianza.controller.api.dto.request.ProccessClientRequest;
import api.alianza.controller.api.dto.response.ProccessClientResponse;
import api.alianza.controller.api.mapper.request.ProccessClientRequestMapper;
import api.alianza.controller.api.mapper.response.ProccessClientResponseMapper;
import api.alianza.domain.models.entity.ProccessClient;
import api.alianza.service.ProccessClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@CrossOrigin
@Slf4j
public class ProcessClientController {
    @Autowired
    private ProccessClientService proccessClientService;

    @Autowired
    private ProccessClientRequestMapper requestMapper;

    @Autowired
    private ProccessClientResponseMapper responseMapper;


    public Class<?> getProccessClientById(int id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<ProccessClientResponse> createClient(@RequestBody ProccessClientRequest requestDTO){
        ProccessClient proccessClient =  requestMapper.toEntity(requestDTO);
        ProccessClient saveProccessClient = proccessClientService.save(proccessClient);
        ProccessClientResponse responseDto = responseMapper.toModel(saveProccessClient);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<ProccessClientResponse>> getAllProccessClient(@RequestParam(defaultValue = "0") int page,
                                                                             @RequestParam(defaultValue = "100") int size){
        Page<ProccessClient> proccessClientsPage = proccessClientService.findAll(PageRequest.of(page, size));
        Page<ProccessClientResponse> responsePage = proccessClientsPage.map(responseMapper::toModel);
        return ResponseEntity.ok(responsePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProccessClientResponse> updateProccessClient(@PathVariable Integer id, @RequestBody ProccessClientRequest requestDTO){
        ProccessClient existingProccessClient = proccessClientService.findById(id);
        ProccessClient updatedProccessClient = requestMapper.toEntity(requestDTO);
        updatedProccessClient.setId(existingProccessClient.getId());
        ProccessClient saveProccessClient = proccessClientService.save(updatedProccessClient);
        ProccessClientResponse responseDto = responseMapper.toModel(saveProccessClient);
        return ResponseEntity.ok(responseDto);
    }

}
