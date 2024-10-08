package com.isreal.apartodo.controller;

import com.isreal.apartodo.document.ChecklistDocument;
import com.isreal.apartodo.document.FaultDocument;
import com.isreal.apartodo.document.QuestionDocument;
import com.isreal.apartodo.dto.ChecklistDTO;
import com.isreal.apartodo.dto.FaultRequestDTO;
import com.isreal.apartodo.dto.PostDTO;
import com.isreal.apartodo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/add-checklist")
    public ChecklistDocument addChecklist(@RequestBody ChecklistDTO checklistDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberService.addCheckList(checklistDTO, username);
    }

    @GetMapping("/find-checklists")
    public List<ChecklistDocument> findChecklists() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberService.findChecklists(username);
    }

    @PostMapping("/fault-request")
    public void faultRequest(@RequestBody FaultRequestDTO faultRequestDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        memberService.faultRequest(faultRequestDTO, username);
    }

    @GetMapping("/find-faults")
    public List<FaultDocument> findFaults() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberService.findFaults(username);
    }

    @PostMapping("/create-question")
    public QuestionDocument createQuestion(PostDTO postDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberService.createQuestion(postDTO, username);
    }
}
