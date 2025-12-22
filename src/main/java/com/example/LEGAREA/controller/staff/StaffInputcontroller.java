package com.example.LEGAREA.controller.staff;

import com.example.LEGAREA.entity.StaffInputEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StaffInputcontroller {

    // 社員追加画面表示
    @GetMapping("/input")
    public String showInputForm(Model model) {
        model.addAttribute("staffInput", new StaffInputEntity());
        return "staff/input"; // add.html を返す
    }
}
