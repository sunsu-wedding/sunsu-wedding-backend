package com.kakao.sunsuwedding.favorite;

import com.kakao.sunsuwedding._core.security.CustomUserDetails;
import com.kakao.sunsuwedding._core.utils.ApiUtils;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/favorite")
public class FavoriteRestController {

    private final FavoriteServiceImpl favoriteServiceImpl;

    @PostMapping("/{portfolioId}")
    public ResponseEntity<?> like(@AuthenticationPrincipal CustomUserDetails userDetails,
                                  @PathVariable @Min(1) Long portfolioId){
        favoriteServiceImpl.likePortfolio(userDetails.getUser(), portfolioId);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    @DeleteMapping("/{portfolioId}")
    public ResponseEntity<?> unlike(@AuthenticationPrincipal CustomUserDetails userDetails,
                                    @PathVariable @Min(1) Long portfolioId){
        favoriteServiceImpl.unlikePortfolio(userDetails.getUser(), portfolioId);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    @GetMapping("")
    public ResponseEntity<?> findFavorites(@AuthenticationPrincipal CustomUserDetails userDetails,
                                           @PageableDefault(size=10, page=0, sort="createdAt", direction = Sort.Direction.DESC) Pageable pageable){
        List<FavoriteResponse.FindPortfolioDTO> favorites = favoriteServiceImpl.findFavoritePortfoliosByUser(userDetails.getUser(), pageable);
        return ResponseEntity.ok().body(ApiUtils.success(favorites));
    }

}
