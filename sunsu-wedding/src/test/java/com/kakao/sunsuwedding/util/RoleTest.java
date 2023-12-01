package com.kakao.sunsuwedding.util;

import com.kakao.sunsuwedding._core.errors.exception.BadRequestException;
import com.kakao.sunsuwedding.user.constant.Role;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoleTest {
    @Test
    public void planner_role_test() {
        String roleName = "planner";
        Role result = Role.valueOfRole(roleName);

        assertThat(result).isEqualTo(Role.PLANNER);
    }
    @Test
    public void couple_role_test() {
        String roleName = "couple";
        Role result = Role.valueOfRole(roleName);

        assertThat(result).isEqualTo(Role.COUPLE);
    }
    @Test
    public void null_role_test() {
        String roleName = "asdf";

        assertThrows(BadRequestException.class, () -> {
            Role.valueOfRole(roleName);
        });
    }
}
