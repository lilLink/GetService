package com.shtukary.ita.service;

import com.shtukary.ita.dto.search.SearchRequestDto;

public interface SearchService<Z> {

    Z getResponse(SearchRequestDto searchRequestDto);

}
