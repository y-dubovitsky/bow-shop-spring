package ru.ydubovitsky.bowshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;

    private String price;

    private String color;

    private String category;

    private String description;

    private Short count;

    private MultipartFile imageByte;

}
