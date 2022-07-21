package web.brk.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AutomoveisDto {

    private int anoFabricacao;
    @NotBlank
    private String placaCarro;
    @NotBlank
    private String modeloCarro;
    @NotBlank
    private String corCarro;
}
