package com.isreal.apartodo.document;

import com.isreal.apartodo.dto.ChecklistDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "checklist")
public class ChecklistDocument {
    @Id
    private String checklistId;

    private String createAt;

    private List<ChecklistDTO.Section> sections;

    private String username; // 입주예정자 이메일

    private String memberName; // 입주예정자 이름

    private String apartmentName;
}
