package com.eminerarslan.kodlama_io_dev.business.responses.subtechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSubTechnologyByIdResponse {
    private int id;
    private String name;
}
