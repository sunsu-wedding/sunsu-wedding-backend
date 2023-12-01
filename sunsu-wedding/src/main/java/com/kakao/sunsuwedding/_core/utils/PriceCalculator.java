package com.kakao.sunsuwedding._core.utils;

import com.kakao.sunsuwedding.match.Match;
import com.kakao.sunsuwedding.match.MatchStatus;
import com.kakao.sunsuwedding.portfolio.PortfolioRequest;
import com.kakao.sunsuwedding.quotation.Quotation;
import com.kakao.sunsuwedding.quotation.QuotationStatus;
import com.kakao.sunsuwedding.portfolio.PortfolioResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.LongStream;

@Component
public class PriceCalculator {
    public Long calculatePortfolioPrice(List<PortfolioResponse.PriceItemDTO> priceItemDTOS) {
        return priceItemDTOS.stream().mapToLong(PortfolioResponse.PriceItemDTO::itemPrice).sum();
    }

    public Long calculateQuotationPrice(List<Quotation> quotations) {
        return quotations.stream().mapToLong(Quotation::getPrice).sum();
    }

    public Long calculateConfirmedQuotationPrice(List<Quotation> quotations) {
        return quotations.stream().mapToLong(quotation -> {
            if (quotation.getStatus().equals(QuotationStatus.CONFIRMED)) {
                return quotation.getPrice();
            }
            else return 0L;
        })
        .sum();
    }

    public Long getContractCount(List<Match> matches){
        return matches.stream()
                .filter(match -> match.getStatus().equals(MatchStatus.CONFIRMED))
                .count();
    }

    public Long calculateAvgPrice(List<Match> matches, Long contractCount) {
        if (contractCount.equals(0L)) return 0L;
        return getConfirmedPriceStream(matches).sum() / contractCount;
    }

    public Long calculateMinPrice(List<Match> matches) {
        return getConfirmedPriceStream(matches).min().orElse(0);
    }

    public Long calculateMaxPrice(List<Match> matches) {
        return getConfirmedPriceStream(matches).max().orElse(0);
    }

    private static LongStream getConfirmedPriceStream(List<Match> matches){
        return matches.stream()
                .filter(match -> match.getStatus().equals(MatchStatus.CONFIRMED))
                .mapToLong(Match::getConfirmedPrice);
    }

    public Long getRequestTotalPrice(List<PortfolioRequest.PriceItemDTO> items) {
        return items.stream()
                .mapToLong(PortfolioRequest.PriceItemDTO::itemPrice)
                .sum();
    }
}
