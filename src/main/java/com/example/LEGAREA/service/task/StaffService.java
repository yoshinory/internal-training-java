package com.example.LEGAREA.service.task;

import com.example.LEGAREA.repository.task.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffService {

    private  final StaffRepository staffRepository;
    public List<StaffEntity> find(){
        return  staffRepository.select();
    }

    public List<StaffDatailEntity> findDatail(String taskid) {


        return staffRepository.selectByID(taskid);


    }

    @Transactional
    public void create(StaffEntity newEntity) {
        staffRepository.insert(newEntity);
    }
}
