package com.furucrm.jgrants.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furucrm.dto.SubsidyDTO;
import com.furucrm.jgrants.entiy.Subsidy;
import com.furucrm.jgrants.entiy.Subsidy.OpenData;
import com.furucrm.jgrants.repository.SubsidyRepository;

@Service
public class SubsidyService {
    
    @Autowired
    private SubsidyRepository subsidyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Subsidy> getAllSubsidy(){
        return subsidyRepository.findAll();
    }

    public SubsidyDTO getSubsidyById(Long subsidyId){
        Subsidy subsidy = subsidyRepository.findById(subsidyId).get();
        System.out.println("subsidy"+ subsidy.getName());
        SubsidyDTO subsidyDTO = modelMapper.map(subsidy, SubsidyDTO.class);
        subsidyDTO.setLastModifiedDate(SubsidyDTO.setDateFromat(subsidy.getLastModifiedDate()));
        subsidyDTO.setInstitutionName(subsidy.getInstitution());
        return subsidyDTO;
    }

    public String updateSubsidy(long subsidyId, Subsidy subsidy){
        try {
            subsidyRepository.save(subsidy);
            return "update Sussefull!";
        } catch (Exception e) {
            return "erro" + e.getLocalizedMessage();
        }
    }

    public List<Subsidy> saveSubsidy(){
        Subsidy subsidy = new Subsidy();
        subsidy.setCanConsult(false);
        subsidy.setName("test");
        subsidy.setTitle("補助金");
        subsidy.setCreatedDate(new Date());
        subsidy.setLastModifiedDate(new Date());
        subsidy.setOpenDataAgreement(OpenData.toEnum("Agree"));
        subsidyRepository.save(subsidy);
        return subsidyRepository.findAll();
    }

    public List<Subsidy> deleteSubsidy(Long subsidyId){

        subsidyRepository.deleteById(subsidyId);

        return subsidyRepository.findAll();
    }
    
}
