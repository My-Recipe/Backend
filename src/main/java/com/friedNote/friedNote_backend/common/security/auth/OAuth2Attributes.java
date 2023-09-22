package com.friedNote.friedNote_backend.common.security.auth;

import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuth2Attributes {

    private Map<String, Object> attributes; //소셜로그인 사용자 정보
    private String nameAttributeKey; //nameAttributeKey값을 통해 arttributes값을 가져올 수 있다.
    private String name;
    private String email;

    @Builder
    public OAuth2Attributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
    }

    public OAuth2Attributes() {
    }

    //OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환하여야 한다.
    public static OAuth2Attributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuth2Attributes.builder()
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .build();
    }

    /**
     * mapper class로 분리
     */
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }
}
