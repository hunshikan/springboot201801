package com.xinrui.controller;


import com.xinrui.component.AuthorMapping;
import com.xinrui.data.model.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户信息管理 API")
@RestController
@RequestMapping(value = "/xinrui/study/demo", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserManageController extends BaseController{


    /**
     *   @PathVariable 路径可变参数，映射路径中的参数
     *   @RequestParam 请求参数
     */


    @ApiOperation(value = "根据用户编号获取用户信息", notes = "根据用户编号获取用户信息")
    @GetMapping(value = "/{userId}/userInfo")
    public UserInfoDTO getUserInfoByUserId(@ApiParam(value = "用户编号: NO.01",required = true)
                                           @PathVariable String userId){

        return userInfoService.getUserInfoByUserId(userId);
    }


    /**
     *  @ResponseBody注解
     *  作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，
     *  写入到response对象的body区，通常用来返回JSON数据或者是XML数据，需要注意的是，
     *  在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，
     *  它的效果等同于通过response对象输出指定格式的数据。
     */
    @GetMapping("/author")
    @ResponseBody
    public AuthorMapping getAuthor() {
        return am;
    }

}
