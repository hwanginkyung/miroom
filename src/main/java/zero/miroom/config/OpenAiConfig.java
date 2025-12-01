package zero.miroom.config;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    private final OpenAiProperties properties;

    public OpenAiConfig(OpenAiProperties properties) {
        this.properties = properties;
    }

    @Bean
    public OpenAIClient openAIClient() {
        return OpenAIOkHttpClient.builder()
                .apiKey(properties.getApiKey())
                // 필요하면 orgId / projectId 도 세팅
                // .organization(properties.getOrgId())
                // .project(properties.getProjectId())
                .build();
    }
}
