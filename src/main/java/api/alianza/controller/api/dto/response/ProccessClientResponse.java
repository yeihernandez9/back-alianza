package api.alianza.controller.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProccessClientResponse extends RepresentationModel<ProccessClientResponse>{

    @Schema(description = "Id client", example = "1")
    private String id;
    @Schema(description = "Name client", example = "yeison Hernandez")
    private String name;

    @Schema(description = "Phone client", example = "3044657392")
    private String phone;

    @Schema(description = "Email client", example = "yeihernandez@ejemplo.com")
    private String email;

    @Schema(description = "Start date client", example = "02/04/2024")
    private String startDate;

    @Schema(description = "end date client", example = "02/04/2024")
    private String endDate;
}
