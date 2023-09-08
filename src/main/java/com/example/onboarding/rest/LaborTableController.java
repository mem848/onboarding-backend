package com.example.onboarding.rest;

import com.example.onboarding.domain.part2pojos.LaborTableCalculated;
import com.example.onboarding.domain.repository.ILaborRepository;
import com.example.onboarding.domain.entity.LaborTable;
import com.example.onboarding.rest.resources.mappers.LaborTableMapper;
import com.example.onboarding.rest.resources.v1.LaborTableRequest;
import com.example.onboarding.rest.resources.v1.LaborTableResponse;
import com.example.onboarding.service.LaborTableService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequiredArgsConstructor
@RequestMapping("/labor")
//@Component
public class LaborTableController {
    @Autowired
    private final ILaborRepository laborRepository;
    @Autowired
    private LaborTableMapper mapper;
    @Autowired
    private LaborTableService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{id}")
    public Optional<LaborTable> getLaborTable(@PathVariable int id)
    {
        logger.debug("getting job");
        logger.trace("trace here");
        logger.error("logger error");
        logger.warn("logger warning");
        return laborRepository.findById(id);
    }

    @PostMapping("")
    public LaborTableResponse insertLabor(@RequestBody LaborTableRequest request)
    {
        //map from request to calculated
        LaborTableCalculated calculated = mapper.requestToCalculated(request);
        //do service on calculated object (this function should return an object)
        service.setCost(calculated);
        //map from calculated to LaborTable (this is a table)
        LaborTable table = mapper.calculatedToTable(calculated);
        //save table, (move this to service)
        laborRepository.save(table);
        //take table and make response
        LaborTableResponse response = mapper.tableToResponse(table);
        return response;
    }
}
