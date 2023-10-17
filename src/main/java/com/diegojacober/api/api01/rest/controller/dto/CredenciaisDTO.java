package com.diegojacober.api.api01.rest.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredenciaisDTO {
    public String login;
    public String senha;
}
