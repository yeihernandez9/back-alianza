package api.alianza.controller.api.mapper.response;

import api.alianza.controller.ProcessClientController;
import api.alianza.controller.api.dto.response.ProccessClientResponse;
import api.alianza.domain.models.entity.ProccessClient;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Mapper(componentModel = "spring")
public abstract class ProccessClientResponseMapper implements RepresentationModelAssembler<ProccessClient, ProccessClientResponse> {
    @Override
    public abstract ProccessClientResponse toModel(ProccessClient entity);

    @AfterMapping
    protected void addLinks(@MappingTarget ProccessClientResponse resource, ProccessClient entity){
        Link selflink =  linkTo(WebMvcLinkBuilder.methodOn(ProcessClientController.class).getProccessClientById(entity.getId())).withSelfRel();
        resource.add(selflink);
    }
}
