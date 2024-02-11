package api.alianza.controller.api.mapper.request;

import api.alianza.controller.api.dto.request.ProccessClientRequest;
import api.alianza.domain.models.entity.ProccessClient;
import jakarta.persistence.MapKey;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public abstract class ProccessClientRequestMapper {
    public abstract ProccessClient toEntity(ProccessClientRequest dto);

    @AfterMapping
    protected void afterMapping(ProccessClientRequest dto, @MappingTarget ProccessClient entity){

    }
}
