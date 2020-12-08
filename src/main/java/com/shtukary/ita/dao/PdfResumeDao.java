package com.shtukary.ita.dao;

import com.shtukary.ita.model.PdfResume;

import java.util.Optional;

public interface PdfResumeDao extends BaseDao<PdfResume, Long> {

    void deleteAll();

    Optional<PdfResume> findByUserId(Long id);

    Optional<PdfResume> findByPdfName(String name);

}
