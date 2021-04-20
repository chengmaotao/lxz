package com.ruoyi.app.service;

import java.util.List;
import com.ruoyi.app.domain.Review;

/**
 * 评论管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public interface IReviewService 
{
    /**
     * 查询评论管理
     * 
     * @param id 评论管理ID
     * @return 评论管理
     */
    public Review selectReviewById(Long id);

    /**
     * 查询评论管理列表
     * 
     * @param review 评论管理
     * @return 评论管理集合
     */
    public List<Review> selectReviewList(Review review);

    /**
     * 新增评论管理
     * 
     * @param review 评论管理
     * @return 结果
     */
    public int insertReview(Review review);

    /**
     * 修改评论管理
     * 
     * @param review 评论管理
     * @return 结果
     */
    public int updateReview(Review review);

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteReviewByIds(String ids);

    /**
     * 删除评论管理信息
     * 
     * @param id 评论管理ID
     * @return 结果
     */
    public int deleteReviewById(Long id);
}
