package com.dellent.labseq.labseqtest.controller;

import com.dellent.labseq.labseqtest.dto.ResponseData;
import com.dellent.labseq.labseqtest.service.LabseqService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labseq")
public class LabseqController {

    private final LabseqService service;

    public LabseqController(LabseqService service) {
        this.service = service;
    }

    @GetMapping("/{index}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseData> getLabseq(@PathVariable Integer index) {

        ResponseData rd;

        if (index < 0) {
            rd = ResponseData.builder()
                    .message("Index cannot be a negative number")
                    .build();
            return new ResponseEntity<>(rd, HttpStatus.BAD_REQUEST);
        }
        rd = ResponseData.builder()
                .message("")
                .data(service.getLabseq(index))
                .build();
        return new ResponseEntity<>(rd, HttpStatus.OK);
    }

    @GetMapping("/array")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseData> getArray() {
        ResponseData rd = ResponseData.builder()
                .message("")
                .data(service.getLabseqArray())
                .build();

        return new ResponseEntity<>(rd, HttpStatus.OK);
    }

}
