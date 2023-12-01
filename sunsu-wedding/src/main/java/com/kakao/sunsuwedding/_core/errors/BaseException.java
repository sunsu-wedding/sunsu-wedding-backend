package com.kakao.sunsuwedding._core.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 모든 에러의 메시지를 관리
@RequiredArgsConstructor
public enum BaseException {
    // 카테고리별로 1000~9000로 나누어 에러 내용을 프론트가 구별하기 쉽도록 함
    // 공통 에러 1000
    PERMISSION_DENIED_METHOD_ACCESS("사용할 수 없는 기능입니다.", 1000, 403),
    DATABASE_ERROR("데이터베이스 에러입니다.", 1001, 500),
    USER_UNAUTHORIZED("인증되지 않았습니다.", 1002, 401),
    INVALID_METHOD_ARGUMENTS("잘못된 매개변수가 입력되었습니다.", 1003, 400),
    UNEXPECTED_EXCEPTION("예상치 못한 에러가 발생했습니다.", 1004, 500),

    // 회원 2000
    USER_NOT_FOUND("서비스를 탈퇴했거나 가입하지 않은 유저의 요청입니다.", 2000, 404),
    PLANNER_NOT_FOUND("서비스를 탈퇴하거나 가입하지 않은 플래너입니다.", 2001, 404),
    USER_EMAIL_EXIST("동일한 이메일이 존재합니다.", 2002, 400),
    USER_EMAIL_NOT_FOUND("이메일을 찾을 수 없습니다.", 2003, 400),
    USER_ROLE_WRONG("role은 플래너, 또는 예비 부부만 가능합니다.", 2004, 400),
    USER_PASSWORD_WRONG("패스워드를 잘못 입력하셨습니다.", 2005, 400),
    USER_PASSWORD_NOT_SAME("패스워드1과 패스워드2는 동일해야 합니다.", 2006, 400),
    USER_ALREADY_PREMIUM("이미 프리미엄 회원입니다.", 2007, 400),

    // 토큰 2100
    ACCESS_TOKEN_EXPIRED("액세스 토큰이 만료되었습니다. 리프레시 토큰으로 다시 요청해주세요.", 2100, 401),
    ACCESS_TOKEN_STILL_ALIVE("액세스 토큰이 아직 유효합니다. 이상한 접근이 감지되었습니다. 다시 로그인해주세요.", 2101, 401),
    ALL_TOKEN_EXPIRED("모든 토큰이 만료되었습니다. 다시 로그인 해주세요.", 2102, 401),
    TOKEN_NOT_FOUND("토큰을 찾을 수 없습니다. 다시 로그인 해주세요.", 2103, 404),
    TOKEN_NOT_VALID("로그인 토큰이 유효하지 않습니다. 다시 로그인 해주세요.", 2104, 401),
    TOKEN_REFRESH_FORBIDDEN("토큰을 갱신할 수 없습니다.", 2105, 401),
    REFRESH_TOKEN_REQUIRED("리프레시 토큰을 가지고 다시 요청해주세요.", 2106, 401),

    // 이메일 2200
    CODE_GENERATE_ERROR("인증코드 생성 과정에서 오류가 발생했습니다.", 2200, 500),
    EMAIL_GENERATE_ERROR("이메일 생성 과정에서 오류가 발생했습니다.", 2201, 500),
    CODE_NOT_FOUND("인증코드 전송 내역이 없습니다. 인증코드를 요청 후 진행해주세요.", 2202, 404),
    CODE_EXPIRED("인증코드가 만료되었습니다. 다시 요청해주세요.", 2203, 400),
    CODE_NOT_MATCHED("인증코드가 일치하지 않습니다.", 2204, 400),
    UNAUTHENTICATED_EMAIL("인증되지 않은 이메일입니다.", 2205, 400),
    EMAIL_ALREADY_AUTHENTICATED("이미 인증이 완료되었습니다.", 2206, 400),

    // 결제 3000
    PAYMENT_WRONG_INFORMATION("잘못된 결제 정보입니다.", 3000, 400),
    PAYMENT_NOT_FOUND("결제 내용이 존재하지 않습니다.", 3001, 404),
    PAYMENT_FAIL("토스페이먼츠 승인 요청에 실패했습니다.", 3002, 400),

    // 포트폴리오 4000
    PORTFOLIO_NOT_FOUND("해당하는 플래너의 포트폴리오가 삭제되었거나 존재하지 않습니다.", 4000, 404),
    PORTFOLIO_ALREADY_EXIST("해당 플래너의 포트폴리오가 이미 존재합니다. 포트폴리오는 플래너당 하나만 생성할 수 있습니다.", 4001, 400),
    PORTFOLIO_IMAGE_NOT_FOUND("포트폴리오 이미지를 불러올 수 없습니다.", 4002, 404),
    PORTFOLIO_IMAGE_COUNT_EXCEED("요청한 이미지의 수가 5개를 초과합니다.", 4003, 400),
    PORTFOLIO_IMAGE_CREATE_ERROR("포트폴리오 이미지 생성 과정에서 오류가 발생했습니다.", 4004, 500),
    PORTFOLIO_IMAGE_ENCODING_ERROR("이미지 인코딩 과정에서 오류가 발생했습니다.", 4005, 500),
    PORTFOLIO_CREATE_DIRECTORY_ERROR("포트폴리오 폴더 생성 과정에서 오류가 발생했습니다.", 4006, 500),
    PORTFOLIO_CLEAN_DIRECTORY_ERROR("포트폴리오 폴더를 비우는 과정에서 오류가 발생했습니다.", 4007, 500),
    PORTFOLIO_IMAGE_DELETE_ERROR("포트폴리오 이미지 삭제 과정에서 오류가 발생했습니다.", 4008, 500),
    PORTFOLIO_IMAGE_PATH_ERROR("포트폴리오 이미지 경로를 구하는 과정에서 오류가 발생했습니다.", 4009, 500),

    // 매칭 관련 5000
    MATCHING_ALREADY_CONFIRMED("전체 확정되어 견적서를 추가할 수 없습니다.", 5000, 400),
    MATCHING_NOT_FOUND("매칭 내역을 찾을 수 없습니다.", 5001, 404),
    MATCHING_ALREADY_EXIST("이미 존재하는 매칭입니다.", 5002, 400),
    MATCHING_NOT_CONFIRMED("견적서 전체 확정이 되지 않았습니다.", 5003, 400),
    MATCHING_USER_NOT_FOUND("매칭 유저가 존재하지 않기 때문에 견적서를 추가할 수 없습니다.", 5004, 404),

    // 견적서 관련 6000
    QUOTATIONS_NOT_ALL_CONFIRMED("확정되지 않은 견적서가 있습니다.", 6000, 400),
    QUOTATION_NOTHING_TO_CONFIRM("확정할 견적서가 없습니다.", 6001, 400),
    QUOTATION_NOT_FOUND("해당 견적서를 찾을 수 없습니다.", 6002, 404),
    QUOTATION_ACCESS_DENIED("해당 매칭 내역에 접근할 수 없습니다.", 6003, 403),
    QUOTATION_ALREADY_CONFIRMED("견적서가 확정된 상태입니다.",6004, 400),

    // 리뷰 7000
    REVIEW_NOT_FOUND("해당 리뷰가 삭제되었거나 존재하지 않습니다.", 7001, 404),
    REVIEW_EXIST("해당 매칭에 대한 리뷰가 이미 존재합니다.", 7002, 400),

    // 찜하기 8000
    FAVORITE_ALREADY_EXISTS("이미 존재하는 찜하기 입니다.", 8001, 400),
    FAVORITE_NOT_FOUND("존재하지 않는 찜하기 입니다.", 8002, 404)

    // 9000 번대는 예약 대역
    ;

    @Getter
    private final String message;

    @Getter
    private final int code;

    @Getter
    private final int status;
}
