package com.example.LEGAREA.service.staff;

import com.example.LEGAREA.entity.StaffDetailEntity;
import com.example.LEGAREA.repository.staff.StaffDeleteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StaffDeleteService {

    private  final StaffDeleteRepository staffDeleteRepository;

    @Transactional
    public String Deletestaff(StaffDetailEntity Entity) {

        try
        {
            if(Entity == null || Entity.getStaffId()==null)
            {
                return "入力データが不正です";
            }

            staffDeleteRepository.deleteStaff(Entity);
            return "削除が正常に終了しました";
        }
        catch (Exception ex)
        {
            // 削除失敗時はメッセージを返す
            return "例外が発生しました";
        }
    }
}
