package com.airconsole.wm_cms.listener.service;


import com.airconsole.wm_cms.common.AppConstants;
import com.airconsole.wm_cms.listener.exception.BadRequestException;

public abstract class PagingService {

    protected void validatePageNumberAndSize(int page, int size) {
        if (size <= 0) {
            throw new BadRequestException("Page number cannot not be less than zero.");
        }

        if (page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if (size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size cannot not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}
