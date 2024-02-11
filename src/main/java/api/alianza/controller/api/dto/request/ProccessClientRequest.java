package api.alianza.controller.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProccessClientRequest {

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
