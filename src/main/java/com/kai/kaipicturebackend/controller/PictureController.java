package com.kai.kaipicturebackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kai.kaipicturebackend.annotation.AuthCheck;
import com.kai.kaipicturebackend.common.BaseResponse;
import com.kai.kaipicturebackend.common.DeleteRequest;
import com.kai.kaipicturebackend.common.ErrorCode;
import com.kai.kaipicturebackend.common.ResultUtils;
import com.kai.kaipicturebackend.constant.UserConstant;
import com.kai.kaipicturebackend.exception.BusinessException;
import com.kai.kaipicturebackend.model.dto.picture.*;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.vo.PictureVO;
import com.kai.kaipicturebackend.service.PictureService;
import com.kai.kaipicturebackend.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图片接口 —— 第 4~8 期任务。
 *
 * 接口清单（先自己设计再对照）：
 * POST   /picture/upload          上传图片（登录用户）
 * POST   /picture/upload/url      URL 上传（第 5 期，登录用户）
 * POST   /picture/upload/batch    批量抓取（第 5 期，管理员）
 * POST   /picture/list/page       分页查询（所有人）
 * GET    /picture/get             图片详情（所有人）
 * POST   /picture/update          更新（管理员）
 * POST   /picture/edit            编辑（本人或管理员）
 * POST   /picture/delete          删除（本人或管理员）
 * POST   /picture/review          审核（第 5 期，管理员）
 * POST   /picture/search/color    颜色搜索（第 8 期，空间内）
 * POST   /picture/edit/batch      批量编辑（第 8 期，空间内）
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Resource
    private PictureService pictureService;

    @Resource
    private UserService userService;

    /**
     * 上传图片（文件）
     */
    @PostMapping("/upload")
    public BaseResponse<PictureVO> uploadPicture(
            @RequestPart("file") MultipartFile multipartFile,
            @RequestPart("request") PictureUploadRequest pictureUploadRequest,
            HttpServletRequest request) {
        // TODO 第 4 期：实现
        // 提示：获取登录用户（getLoginUser）→ pictureService.uploadPicture(...) → success
        return null;
    }

    /**
     * 通过 URL 上传（第 5 期）
     */
    @PostMapping("/upload/url")
    public BaseResponse<PictureVO> uploadPictureByUrl(
            @RequestBody PictureUploadByUrlRequest pictureUploadByUrlRequest,
            HttpServletRequest request) {
        // TODO 第 5 期：实现
        return null;
    }

    /**
     * 批量抓取（第 5 期，管理员）
     */
    @PostMapping("/upload/batch")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Integer> uploadPictureByBatch(
            @RequestBody PictureUploadByBatchRequest pictureUploadByBatchRequest,
            HttpServletRequest request) {
        // TODO 第 5 期：实现
        return null;
    }

    /**
     * 分页查询图片（第 4 期）
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<PictureVO>> listPictureVOByPage(
            @RequestBody PictureQueryRequest pictureQueryRequest,
            HttpServletRequest request) {
        // TODO 第 4 期：实现
        // 提示：参考 UserController.listUserVOByPage 的分页写法
        return null;
    }

    /**
     * 图片详情（第 4 期）
     */
    @GetMapping("/get")
    public BaseResponse<PictureVO> getPictureVOById(long id, HttpServletRequest request) {
        // TODO 第 4 期：实现
        return null;
    }

    /**
     * 更新图片（管理员）
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updatePicture(@RequestBody PictureUpdateRequest pictureUpdateRequest) {
        // TODO 第 4 期：实现
        return null;
    }

    /**
     * 编辑图片（本人或管理员）
     */
    @PostMapping("/edit")
    public BaseResponse<Boolean> editPicture(@RequestBody PictureEditRequest pictureEditRequest,
                                             HttpServletRequest request) {
        // TODO 第 4 期：实现
        return null;
    }

    /**
     * 删除图片（本人或管理员）
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deletePicture(@RequestBody DeleteRequest deleteRequest,
                                               HttpServletRequest request) {
        // TODO 第 4 期：实现
        return null;
    }

    /**
     * 审核图片（第 5 期，管理员）
     */
    @PostMapping("/review")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> doPictureReview(@RequestBody PictureReviewRequest pictureReviewRequest,
                                                 HttpServletRequest request) {
        // TODO 第 5 期：实现
        return null;
    }

    /**
     * 按颜色搜索（第 8 期）
     */
    @PostMapping("/search/color")
    public BaseResponse<List<PictureVO>> searchPictureByColor(
            @RequestBody SearchPictureByColorRequest searchPictureByColorRequest,
            HttpServletRequest request) {
        // TODO 第 8 期：实现
        return null;
    }

    /**
     * 批量编辑（第 8 期）
     */
    @PostMapping("/edit/batch")
    public BaseResponse<Boolean> editPictureByBatch(
            @RequestBody PictureEditByBatchRequest pictureEditByBatchRequest,
            HttpServletRequest request) {
        // TODO 第 8 期：实现
        return null;
    }
}
