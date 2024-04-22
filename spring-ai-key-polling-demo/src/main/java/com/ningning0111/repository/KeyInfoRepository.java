package com.ningning0111.repository;

import com.ningning0111.entity.KeyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project: com.ningning0111.repository
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/22 17:22
 * @Description:
 */
@Repository
public interface KeyInfoRepository extends JpaRepository<KeyInfo,Long> {
}
