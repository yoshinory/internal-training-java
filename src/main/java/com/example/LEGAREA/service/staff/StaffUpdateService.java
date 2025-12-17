package com.example.LEGAREA.service.staff;

import com.example.LEGAREA.entity.StaffDetailEntity;
import com.example.LEGAREA.repository.staff.StaffUpdateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StaffUpdateService {

    private  final StaffUpdateRepository staffUpdateRepository;

    @Transactional
    public String updateDatail(StaffDetailEntity Entity) {

        String message=null;

        try
        {
            if(Entity == null || Entity.getStaffId()==null)
            {
                return "入力データが不正です";
            }

            staffUpdateRepository.updateStaff(Entity);
            return "更新が正常に終了しました";
        }
        catch (Exception ex)
        {
            // 更新失敗時はメッセージを返す
            message="例外が発生しました";
            return message;
        }
    }
}
