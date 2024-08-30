package net.javaguides.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    @NotEmpty
    private String title;
    private String url;
    @NotEmpty
    private String content;
    @NotEmpty
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    // Getters and setters{
}
