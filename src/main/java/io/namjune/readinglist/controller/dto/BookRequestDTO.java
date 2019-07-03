package io.namjune.readinglist.controller.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Copyright (c) 2018 ZUM Internet, Inc. All right reserved. http://www.zum.com This software is the
 * confidential and proprietary information of ZUM , Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license agreement you
 * entered into with ZUM.
 *
 * Revision History Author                    Date                     Description
 * ------------------       --------------            ------------------ njkim 2019-07-02
 */
@NoArgsConstructor
@Getter
@Setter
public class BookRequestDTO {

    @NotEmpty
    private String isbn;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @NotEmpty
    private String description;

    @Builder
    public BookRequestDTO(String isbn, String title, String author, String description) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
    }
}
