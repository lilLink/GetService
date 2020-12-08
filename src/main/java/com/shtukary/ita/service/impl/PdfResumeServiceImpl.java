package com.shtukary.ita.service.impl;

import com.shtukary.ita.service.PdfResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shtukary.ita.dao.PdfResumeDao;
import com.shtukary.ita.model.PdfResume;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PdfResumeServiceImpl implements PdfResumeService {

    private final PdfResumeDao pdfResumeDao;

    @Autowired
    public PdfResumeServiceImpl(PdfResumeDao pdfResumeDao) {
        this.pdfResumeDao = pdfResumeDao;
    }

    @Override
    public Optional<PdfResume> findById(Long id) {
        return pdfResumeDao.findById(id);
    }

    @Override
    public List<PdfResume> findAll() {
        return pdfResumeDao.findAll();
    }

    @Override
    public void save(PdfResume pdfResume) {
        pdfResumeDao.save(pdfResume);
    }

    @Override
    public PdfResume update(PdfResume pdfResume) {
        return pdfResumeDao.update(pdfResume);
    }

    @Override
    public void deleteById(Long id) {
        pdfResumeDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        pdfResumeDao.deleteAll();
    }

    @Override
    public Optional<PdfResume> findByUserId(Long id) {
        return pdfResumeDao.findByUserId(id);
    }

    @Override
    public Optional<PdfResume> findByPdfName(String name) {
        return pdfResumeDao.findByPdfName(name);
    }

}
