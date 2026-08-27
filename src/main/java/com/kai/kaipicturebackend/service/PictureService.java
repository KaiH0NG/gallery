package com.kai.kaipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.kaipicturebackend.model.dto.picture.*;
import com.kai.kaipicturebackend.model.entity.Picture;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图片服务接口 —— 本项目业务量最大的服务。
 *
 * 方法分期（第 4~8 期）：
 * - 第 4 期：uploadPicture / deletePicture / editPicture / validPicture / getQueryWrapper / getPictureVO / getPictureVOPage
 * - 第 5 期：doPictureReview / uploadPictureByUrl / uploadPictureByBatch
 * - 第 8 期：searchPictureByColor / editPictureByBatch
 *
 * 面试重点：图片服务的权限校验（谁能传、谁能改、谁能删）
 */
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片（本地文件）
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    /**
     * 通过 URL 上传图片（第 5 期）
     */
    PictureVO uploadPictureByUrl(PictureUploadByUrlRequest pictureUploadByUrlRequest,
                                 User loginUser);

    /**
     * 批量抓取图片并创建（第 5 期，管理员）
     */
    Integer uploadPictureByBatch(PictureUploadByBatchRequest pictureUploadByBatchRequest,
                                 User loginUser);

    /**
     * 删除图片（同时删除 COS 文件，第 4/7 期）
     */
    void deletePicture(long pictureId, User loginUser);

    /**
     * 编辑图片（普通用户，第 4 期）
     */
    void editPicture(PictureEditRequest pictureEditRequest, User loginUser);

    /**
     * 图片数据校验（名称长度、分类、标签等，第 4 期）
     */
    void validPicture(Picture picture);

    /**
     * 图片审核（第 5 期，管理员）
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * 根据查询条件构造 QueryWrapper（第 4 期）
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 单张图片转 VO（组装创建人昵称，第 4 期）
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 分页图片转 VO 分页（第 4 期）
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 按颜色搜索图片（第 8 期）
     */
    List<PictureVO> searchPictureByColor(Long spaceId, String picColor, User loginUser);

    /**
     * 批量编辑图片（第 8 期）
     */
    void editPictureByBatch(PictureEditByBatchRequest pictureEditByBatchRequest, User loginUser);

    /**
     * 清理图片文件（删除记录时同步删 COS 文件，第 7 期优化）
     */
    void clearPictureFile(Picture oldPicture);
}
