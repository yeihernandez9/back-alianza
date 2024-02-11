package api.alianza.domain.repositories;

import api.alianza.domain.models.entity.ProccessClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProccessClientRepository extends JpaRepository<ProccessClient, Integer>, JpaSpecificationExecutor<ProccessClient> {
}
