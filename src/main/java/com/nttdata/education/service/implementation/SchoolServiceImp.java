package com.nttdata.education.service.implementation;

import com.nttdata.education.dto.requests.SchoolRequestDto;
import com.nttdata.education.dto.responses.SchoolResponseDto;
import com.nttdata.education.entity.School;
import com.nttdata.education.repository.ISchoolRepository;
import com.nttdata.education.service.interfaces.ISchoolService;
import com.nttdata.education.service.mapper.SchoolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImp implements ISchoolService {

    private final SchoolMapper schoolMapper;
    private final ISchoolRepository schoolRepository;

    public SchoolServiceImp(SchoolMapper schoolMapper, ISchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<SchoolResponseDto> getAll() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SchoolResponseDto getById(Integer id) {
        return schoolRepository.findById(id)
                .map(schoolMapper::toResponse)
                .orElse(null);
    }

    @Override
    public SchoolResponseDto create(SchoolRequestDto schoolRequestDto) {
        return schoolMapper.toResponse(
                schoolRepository.save(
                        schoolMapper.toEntity(schoolRequestDto)
                )
        );
    }

    @Override
    public SchoolResponseDto updateById(Integer id, SchoolRequestDto schoolRequestDto) {
        School actualSchool = schoolRepository.findById(id).orElse(null);
        if (actualSchool == null) {
            return new SchoolResponseDto(null, null, null);
        }
        actualSchool.setName(schoolRequestDto.name());
        actualSchool.setAddress(schoolRequestDto.address());
        actualSchool.setPhone(schoolRequestDto.phone());
        return schoolMapper.toResponse(schoolRepository.save(actualSchool));
    }

    @Override
    public void deleteById(Integer id) {
        schoolRepository.deleteById(id);
    }

}
