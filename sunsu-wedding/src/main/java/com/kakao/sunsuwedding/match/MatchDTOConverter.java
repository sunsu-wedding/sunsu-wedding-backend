package com.kakao.sunsuwedding.match;

import com.kakao.sunsuwedding._core.utils.DateFormat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchDTOConverter {
    public List<MatchResponse.MatchDTO> toFindAllWithNoReviewDTO(List<Match> matches) {
        // 플래너가 탈퇴한 경우는 조회 X
        List<Match> availableMatches = matches.stream().filter(match -> match.getPlanner() != null).toList();

        return availableMatches.stream()
                .map(match -> new MatchResponse.MatchDTO(
                        match.getChat().getId(),
                        match.getPlanner().getId(),
                        match.getPlanner().getUsername(),
                        DateFormat.dateFormatKorean(match.getConfirmedAt()))
                )
                .toList();
    }
}