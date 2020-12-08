package com.shtukary.ita.service.impl.search;

import com.shtukary.ita.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shtukary.ita.dao.impl.search.SearchResumeDao;
import com.shtukary.ita.dto.search.SearchRequestDto;
import com.shtukary.ita.dto.search.SearchResumeResponseDto;

@Component
@Slf4j
public class SearchResumeService implements SearchService<SearchResumeResponseDto> {

    private final SearchResumeDao searchResumeDao;

    @Autowired
    public SearchResumeService(SearchResumeDao searchResumeDao) {
        this.searchResumeDao = searchResumeDao;
    }

    @Override
    public SearchResumeResponseDto getResponse(SearchRequestDto searchRequestDto) {
        return searchResumeDao.getResponse(searchRequestDto);
    }

}

