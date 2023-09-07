package com.dellent.labseq.labseqtest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseData {

    private String message;
    private Object data;

}
