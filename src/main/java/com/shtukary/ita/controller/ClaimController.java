package com.shtukary.ita.controller;

import com.shtukary.ita.model.Claim;
import com.shtukary.ita.model.Company;
import org.springframework.web.bind.annotation.*;
import com.shtukary.ita.service.ClaimService;
import com.shtukary.ita.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final CompanyService companyService;
    private final ClaimService claimService;

    public ClaimController(CompanyService companyService, ClaimService claimService) {
        this.companyService = companyService;
        this.claimService = claimService;
    }

    @PostMapping(value = "/create")
    public Company createClaim(@RequestBody Claim claim) {
        Company company = claim.getCompany();
        claimService.save(claim);

        return companyService.update(company);
    }

    @GetMapping(value = {"/byCompany/{companyId}"})
    public List<Claim> findClaims(@PathVariable("companyId") long companyId) {
        return claimService.findAllByCompanyId(companyId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClaim(@PathVariable("id") long id) {
        claimService.deleteById(id);
    }

}
