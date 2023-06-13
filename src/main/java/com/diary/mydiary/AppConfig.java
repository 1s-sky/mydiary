package com.diary.mydiary;

import com.diary.mydiary.Diary.DiaryRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    private final DataSource dataSource;
    public AppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public DiaryRepository diaryRepository() {
        return new DiaryRepository(dataSource);
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("message/label");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
