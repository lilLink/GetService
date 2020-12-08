package com.shtukary.ita.dao;

import com.shtukary.ita.model.Claim;

import java.util.List;

public interface ClaimDao extends BaseDao<Claim, Long> {

    List<Claim> findAllByCompanyId(Long id);

}
