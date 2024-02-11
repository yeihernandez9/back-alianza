package api.alianza.service.implement;

import api.alianza.domain.models.entity.ProccessClient;
import api.alianza.domain.repositories.ProccessClientRepository;
import api.alianza.exception.ApplicationException;
import api.alianza.exception.Errors;
import api.alianza.service.ProccessClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class ProccessClientImpl implements ProccessClientService {

    Logger logger = LoggerFactory.getLogger(ProccessClientImpl.class);

    @Autowired
    private ProccessClientRepository proccessClientRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ProccessClient> findAll(Pageable pageable) {
        logger.info("Fain all client");
        return proccessClientRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public ProccessClient findById(Integer id) {

        logger.info("Find client by Id");

        return proccessClientRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(Errors.ITEM_NOT_FOUND,
                        Map.of("info", "ProccessClient with id " + id + " not found")));
    }

    @Override
    @Transactional
    public ProccessClient save(ProccessClient procesosClient) {
        logger.info("Save client");
        return proccessClientRepository.save(procesosClient);
    }

    public void setProccessClientRepository(ProccessClientRepository proccessClientRepository) {
    }
}
