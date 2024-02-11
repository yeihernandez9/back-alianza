package api.alianza.service;

import api.alianza.domain.models.entity.ProccessClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProccessClientService {
    Page<ProccessClient> findAll(Pageable pageable);
    ProccessClient findById(Integer id);
    ProccessClient save(ProccessClient procesosClient);
}
