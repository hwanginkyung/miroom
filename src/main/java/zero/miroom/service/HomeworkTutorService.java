/*
package zero.miroom.service;



import com.openai.models.ChatCompletionCreateParams;
import org.springframework.stereotype.Service;
import zero.miroom.config.OpenAiProperties;
import zero.miroom.dto.HomeworkRequest;

import java.util.List;

@Service
public class HomeworkTutorService {

    private final OpenAI openAI;
    private final OpenAiProperties properties;

    public HomeworkTutorService(OpenAI openAI, OpenAiProperties properties) {
        this.openAI = openAI;
        this.properties = properties;
    }

    public String askTutor(HomeworkRequest req) {
        double temperature = properties.getTemperature() != null ? properties.getTemperature() : 0.35;

        if ("debug".equalsIgnoreCase(req.getMode())) {
            temperature = 0.2;
        } else if ("brainstorm".equalsIgnoreCase(req.getMode())) {
            temperature = 0.7;
        }

        String userContent = """
                [과목] : %s
                [과제 유형] : %s
                [과제 설명] : %s
                [내가 이미 시도한 것] : %s
                [어디가 막혔는지] : %s
                """.formatted(
                nullToEmpty(req.getSubject()),
                nullToEmpty(req.getType()),
                nullToEmpty(req.getDescription()),
                nullToEmpty(req.getTried()),
                nullToEmpty(req.getBlocked())
        );

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(properties.getModel())
                .temperature((float) temperature)
                .maxTokens(properties.getMaxTokens())
                .topP(1.0)
                .messages(List.of(
                        ChatCompletionMessageParam.ofSystem("""
당신은 학생들의 과제를 도와주는 튜터형 챗봇이다.

역할:
- 정답을 대신 해주는 것이 아니라, 학생이 스스로 풀 수 있도록
  개념 설명, 접근 방법, 힌트를 중심으로 도와준다.
- 항상 단계별(1, 2, 3…)로 설명한다.

규칙:
1. 시험/퀴즈/평가처럼 보이는 문제는 정답을 직접 제시하지 않고,
   관련 개념과 풀이 전략만 설명한다.
2. 코딩 과제는 완성 코드를 통째로 주지 말고,
   에러 분석, 개념 설명, 부분 수정 예시 위주로 알려준다.
3. 마지막에는 한국어로
   - "요약: ..."
   - "이제 직접 해볼 것: ..."
   형식으로 마무리한다.
"""),
                        ChatCompletionMessageParam.ofUser(userContent)
                ))
                .build();

        Chat chat = openAI.chat();
        var result = chat.completions().create(params);

        return result.choices().get(0).message().content().get(0).text();
    }

    private String nullToEmpty(String s) {
        return s == null ? "" : s;
    }
}
*/
