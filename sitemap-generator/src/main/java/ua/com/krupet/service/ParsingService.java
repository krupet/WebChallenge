package ua.com.krupet.service;

import ua.com.krupet.common.ParsingServiceException;

import java.util.List;

/**
 * Created by krupet on 24.03.2015.
 */
public interface ParsingService {
    List<String> parsePage(String url) throws ParsingServiceException;
}
