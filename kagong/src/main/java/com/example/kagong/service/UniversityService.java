package com.example.kagong.service;

import com.example.kagong.entity.University;
import com.example.kagong.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    /*
     * 대학교 등록
     */
    @Transactional
    public Long save(University university){
        // 중복 이름의 대학 조회
        validateDuplicateUniv(university.getUnivName());

        universityRepository.save(university);
        return university.getUnivId();
    }

    private void validateDuplicateUniv(String univName) {
        List<University> findUniversities = universityRepository.findByName(univName);

        if(!findUniversities.isEmpty()){
            throw new IllegalStateException("이미 존재하는 대학교입니다.");
        }
    }

    /*
     * 전체 대학교 조회
     */
    public List<University> findUniversities(){
        return universityRepository.findAll();
    }

    /*
     * 단일 대학교 조회
     */
    public University findUniversity(long univId){
        return universityRepository.findOne(univId);
    }

    /*
     * 대학교 삭제
     */
    public void deleteUniversity(long univId){
        universityRepository.deleteUniversity(univId);
    }

    public University findUniversityByUnivName(String univName) {
        return universityRepository.findByName(univName).get(0);
    }
}
