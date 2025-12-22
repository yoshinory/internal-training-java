package com.example.LEGAREA.controller.staff;

import com.example.LEGAREA.entity.StaffDetailEntity;
import com.example.LEGAREA.service.staff.StaffService;
import com.example.LEGAREA.service.staff.StaffUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class StaffUpdatecontroller {

    private final StaffService staffService;
    private final StaffUpdateService staffUpdateService;

    // 社員情報更新画面表示
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam(value = "staffId", required = false) String staffId,
                                 Model model) {
        StaffDetailEntity staff = (staffId == null)
                ? new StaffDetailEntity()
                : staffService.findDatail(staffId);


        model.addAttribute("staffUpdate", staff); //
        return "staff/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("staffUpdate") StaffDetailEntity staffDetail,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return "staff/update";
        }
        String message=staffUpdateService.updateDatail(staffDetail);

        // メッセージをモデルに渡す
        model.addAttribute("message", message);

        return showUpdateForm(staffDetail.getStaffId(), model);
    }
}
