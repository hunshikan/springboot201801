package com.xinrui.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "Swagger注解查询API")
@RestController
@RequestMapping(value = "/xinrui/demo", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SwaggerApplicationController extends BaseController {



    @ApiOperation(value = "获取swagger常用注解", notes = "获取swagger常用注解")
    @GetMapping(value = "/swagger/annotation")
    public String getSwaggerAnnotation() {
        return "{\"@Api\":\"用于类\", \"@ApiOperation\":\"用于方法\"," +
                "\"@ApiParam\":\"用于方法、方法参数、字段\",\"@ApiModel\":\"用于类\"," +
                "\"@ApiModelProperty\":\"用于方法和字段\",\"@ApiIgnore\":\"用于类、方法、方法参数\"," +
                "\"@ApiImplicitParam\":\"用于方法\",\"@ApiImplicitParams\":\"用于方法\"}";
    }

    /**
     *  @GetMapping、@PostMapping、@PutMapping、@DeleteMapping、@PatchMapping｝，
     *
     *  来帮助简化常用的HTTP方法的映射，并更好地表达被注解方法的语义。
     *  以@GetMapping为例，Spring官方文档说：
     *     @GetMapping   ============》 @RequestMapping(method = RequestMethod.GET)的缩写
     *    （ Spring4.3中引进）
     *
     *    @RequestMapping(value = "/swagger/message", produces = {MediaType.APPLICATION_JSON_VALUE})
     *    produces ： @RequestMapping 注解类的时候使用， 且方法返回值必须是json格式
     *
     */
    @ApiOperation(value = "获取swagger注解使用说明", notes = "输入swagger注解名,获取使用说明")
    @GetMapping(value = "/swagger/message")
    public String getUseMessage(@ApiParam(value = "注解", required = true)
                                    @RequestParam String annottaion) {


        return "{\"message\" : \"未完成\"}";
    }

}
