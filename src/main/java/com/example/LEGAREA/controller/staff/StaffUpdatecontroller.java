package com.example.LEGAREA.controller.staff;

import com.example.LEGAREA.entity.StaffDetailEntity;
import com.example.LEGAREA.service.staff.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class StaffUpdatecontroller {

    private final StaffService staffService;

    // 社員情報更新画面表示
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam(value = "staffId", required = false) String staffId,
                                 Model model) {
        StaffDetailEntity staff = new StaffDetailEntity();

        model.addAttribute("staffUpdate", staff); //
        return "staff/update";
    }
}
