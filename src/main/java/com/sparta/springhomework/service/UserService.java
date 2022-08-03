package com.sparta.springhomework.service;

import java.util.Collections;

import com.sparta.springhomework.domain.Authority;
import com.sparta.springhomework.domain.User;
import com.sparta.springhomework.dto.UserDto;
import com.sparta.springhomework.repository.UserRepository;
import com.sparta.springhomework.security.util.SecurityUtil;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDto signup(UserDto userDto) {
        String patternId = "^[a-zA-z0-9]{4,12}$";
        String patternPwd = "^[a-z0-9]{4,32}$";

        if(!userDto.getUsername().matches(patternId)) {
            throw new IllegalArgumentException("아이디 형식이 맞지 습니다.");
        }

        if(!userDto.getPassword().matches(patternPwd)) {
            throw new IllegalArgumentException("비밀번호 형식이 맞지 습니다.");
        }

        if(!userDto.getPassword().equals(userDto.getPasswordChk())) {
            throw new IllegalArgumentException("비밀번호를 다시확인해주세요.");
        }

        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new DuplicateKeyException("이미 가입된 유저");
          //  DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }
        System.out.println("userDTO정보 : " + userDto.toString());

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

//        User user = new User();
//        user.setUsername(user.getUsername());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setNickname(userDto.getNickname());

     //   System.out.println("user정보 : " + userRepository.save(user));


        return UserDto.from(userRepository.save(user));

    //    return null;
    }

    // username을 통해서 권한정보를 가져옴
    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String username) {
        return UserDto.from(userRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
    }

    // 현제 SecurityContext에 저장된 username의 해당하는 권한정보를 가져옴
    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername).orElse(null));
    }
}