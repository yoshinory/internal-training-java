package com.example.LEGAREA.service.staff;

import com.example.LEGAREA.entity.StaffDetailEntity;
import com.example.LEGAREA.entity.StaffEntity;
import com.example.LEGAREA.entity.StaffInputEntity;
import com.example.LEGAREA.repository.staff.StaffInputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StaffInputService {

    private final StaffInputRepository staffInputRepository;

    @Transactional
    public String create(StaffInputEntity input) {

        try {
            // 入力情報から各テーブルの情報を作成
            StaffEntity staff = new StaffEntity(input.getStaffId(), input.getName(), input.getDivision());

            StaffDetailEntity staffDetail = new StaffDetailEntity(input.getStaffId(), input.getName(), input.getDivision(),
                    input.getFirstName(), input.getLastName(), input.getPosition(), input.getAge());

            // 社員テーブルに情報を追加
            staffInputRepository.staffcreate(staff);

            // 社員詳細テーブルに情報を追加
            staffInputRepository.staffDetailcreate(staffDetail);

            return "登録に成功しました";
        }
        catch (Exception ex)
        {
            return "登録に失敗しました。";
        }
    }
}
