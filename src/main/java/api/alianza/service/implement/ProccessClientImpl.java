package api.alianza.service.implement;

import api.alianza.domain.models.entity.ProccessClient;
import api.alianza.domain.repositories.ProccessClientRepository;
import api.alianza.exception.ApplicationException;
import api.alianza.exception.Errors;
import api.alianza.service.ProccessClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class ProccessClientImpl implements ProccessClientService {

    @Autowired
    private ProccessClientRepository proccessClientRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ProccessClient> findAll(Pageable pageable) {
        return proccessClientRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public ProccessClient findById(Integer id) {
        return proccessClientRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(Errors.ITEM_NOT_FOUND,
                        Map.of("info", "ProccessClient with id " + id + " not found")));
    }

    @Override
    @Transactional
    public ProccessClient save(ProccessClient procesosClient) {
        return proccessClientRepository.save(procesosClient);
    }

    public void setProccessClientRepository(ProccessClientRepository proccessClientRepository) {
    }
}
