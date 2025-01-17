package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import com.feiniaojin.gracefuresponse.example.dto.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v")
@Slf4j
@Tag(name = "参数校验场景演示接口", description = "演示GracefulResponse对参数校验的支持")
public class ValidationController {

    /**
     * http://localhost:9090/example/validateDto
     *
     * @param dto
     */
    @PostMapping("/validateDto")
//    @ValidationStatusCode(code = "123")
    public void validateDto(@Validated UserInfoQuery dto) {
        log.info(dto.toString());
    }

    /**
     * http://localhost:9090/example/validateDto
     *
     * @param dto
     */
    @PostMapping("/validateDto1")
    @ValidationStatusCode(code = "123")
    public void validateDto1(@Validated UserInfoQuery dto) {
        log.info(dto.toString());
    }

    /**
     * 测试Controller中方法对参数进行校验的情形.
     * http://localhost:9090/example/validateMethodParam
     *
     * @param userId 非空
     */
    @PostMapping("/validateMethodParam")
//    @ValidationStatusCode(code = "1314")
    public void validateMethodParam(@NotNull(message = "userId不能为空") Long userId,
                                    @NotNull(message = "userName不能为空") Long userName) {
        log.info("" + userId);

    }

    /**
     * http://localhost:9090/example/validatePropertyList
     *
     * @param dto
     */
    @PostMapping("/validatePropertyList")
//    @ValidationStatusCode(code = "523")
    public void validatePropertyList(@Valid @RequestBody PropertyListMethodDTO dto) {
        log.info("");
    }

    /**
     * http://localhost:9090/example/validateMethodDto
     *
     * @param dto
     */
    @PostMapping("/validateMethodDto")
//    @ValidationStatusCode(code = "523")
    public void validateMethodDto(@Validated @RequestBody MethodDTO dto) {
        log.info("");
    }

    /**
     * http://localhost:9090/example/validate/propertyType
     *
     * @param command
     */
    @PostMapping("/validate/propertyType")
    public void validatePropertyType(@RequestBody @Validated UserInfoCommand command) {
        log.info("");
    }

    /**
     * @param classValidateCode
     */
    @PostMapping("/classValidateCode")
    public void classValidateCode(@Validated @RequestBody ClassValidateCode classValidateCode) {

    }

    /**
     * http://localhost:9090/v/customValidation
     *
     * @param query
     */
    @PostMapping("/customValidation")
    public void customValidation(@Validated CustomValidationUserQuery query) {
    }
}
