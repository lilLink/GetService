package com.shtukary.ita.service.impl.search;

import com.shtukary.ita.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shtukary.ita.dao.impl.search.SearchVacancyDao;
import com.shtukary.ita.dto.search.SearchRequestDto;
import com.shtukary.ita.dto.search.SearchVacancyResponseDto;


@Component
@Slf4j
public class SearchVacancyService implements SearchService<SearchVacancyResponseDto> {

    private final SearchVacancyDao searchVacancyDao;

    @Autowired
    public SearchVacancyService(SearchVacancyDao searchVacancyDao) {
        this.searchVacancyDao = searchVacancyDao;
    }

    @Override
    public SearchVacancyResponseDto getResponse(SearchRequestDto searchRequestDto) {
        return searchVacancyDao.getResponse(searchRequestDto);
    }

}
