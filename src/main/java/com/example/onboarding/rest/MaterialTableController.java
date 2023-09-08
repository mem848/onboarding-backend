package com.example.onboarding.rest;

import com.example.onboarding.domain.part2pojos.MaterialTableCalculated;
import com.example.onboarding.domain.entity.MaterialTable;
import com.example.onboarding.domain.repository.IMaterialRepository;
import com.example.onboarding.rest.resources.mappers.MaterialTableMapper;
import com.example.onboarding.rest.resources.v1.MaterialTableRequest;
import com.example.onboarding.rest.resources.v1.MaterialTableResponse;
import com.example.onboarding.service.MaterialTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RequestMapping("/material")
@RestController
@RequiredArgsConstructor
public class MaterialTableController {
    @Autowired
    private final IMaterialRepository materialRepository;
    @Autowired
    private MaterialTableMapper mapper;

    //when we put in some id, we may or may not receive a row of materialTable
    @GetMapping("/{id}")
    public Optional<MaterialTable> getMaterialTable(@PathVariable int id)
    {
        return materialRepository.findById(id);
    }

    @PostMapping("")
    public MaterialTableResponse insertMaterial(@RequestBody MaterialTableRequest request)
    {
        //request to calculated
        MaterialTableCalculated calculated = mapper.requestToCalculated(request);
        //set cost via service
        MaterialTableService service = new MaterialTableService();
        service.setGallonsRequired(calculated);
        //calculated to table
        MaterialTable table = mapper.calculatedToTable(calculated);
        materialRepository.save(table);
        //table to response
        return mapper.tableToResponse(table);

    }
}
