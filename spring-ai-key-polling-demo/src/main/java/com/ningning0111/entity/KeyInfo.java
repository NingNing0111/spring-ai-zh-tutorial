package com.ningning0111.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project: com.ningning0111.entity
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/22 17:15
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class KeyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String key;
    @Column(nullable = false,columnDefinition = "VARCHAR(50) DEFAULT 'https://api.openai.com'")
    private String api;

    // 描述这个Key干嘛的 可空
    private String description;

}
