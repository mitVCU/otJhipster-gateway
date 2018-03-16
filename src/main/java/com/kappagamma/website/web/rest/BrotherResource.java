package com.kappagamma.website.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.kappagamma.website.domain.Brother;
import com.kappagamma.website.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BrotherResource {

    private static final Logger log = LoggerFactory.getLogger(BrotherResource.class);

    private static List<Brother> brothers = new ArrayList<>();



    public BrotherResource() {
        brothers.add(new Brother(
            250,
            "Jonathan",
            "Justino",
            "Samson",
            "Computer Science"));
    }

    @GetMapping("/brothers")
    @Timed
    public List<Brother> getAllBrothers() {
        return brothers;
    }

    @PostMapping("/brothers")
    @Timed
    public ResponseEntity<Brother> createBrother(@Valid @RequestBody Brother brother) throws Exception {
        brothers.add(brother);
        return ResponseEntity
            .created(new URI("/api/brothers" + brother.getRollNumber()))
            .headers(HeaderUtil.createEntityCreationAlert("brother",
                brother.getRollNumber().toString()))
            .body(brother);
    }

    /*
    @PostMapping("/brothers1")
    @Timed
    public List<Brother> ResponseEntity<Brother>
    */

}
